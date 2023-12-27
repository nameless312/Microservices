package org.nameless.application;

import lombok.extern.slf4j.Slf4j;
import org.nameless.amqp.RabbitMQMessageProducer;
import org.nameless.core.customer.Customer;
import org.nameless.core.customer.CustomerService;
import org.nameless.fraud.FraudClient;
import org.nameless.infra.customer.CustomerRepository;
import org.nameless.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private RabbitMQMessageProducer rabbitMQMessageProducer;
    private final FraudClient fraudClient;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               RabbitMQMessageProducer rabbitMQMessageProducer,
                               FraudClient fraudClient) {
        this.customerRepository = customerRepository;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
        this.fraudClient = fraudClient;
    }

    public void registerCustomer(Customer customer) {
        customer = customerRepository.saveCustomer(customer);
        // check email

        // check if fraudster
        fraudClient.isFraudster(customer.getId());

        // send notification
        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(), customer.getEmail(), "Hi there mr.");

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
