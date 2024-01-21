package org.nameless.application;

import org.nameless.infra.amqp.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
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
//    private RabbitMQMessageProducer rabbitMQMessageProducer;

    private final KafkaProducer kafkaProducer;
    private final FraudClient fraudClient;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               KafkaProducer kafkaProducer,
//                               RabbitMQMessageProducer rabbitMQMessageProducer,
                               FraudClient fraudClient) {
        this.customerRepository = customerRepository;
        this.kafkaProducer = kafkaProducer;
//        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
        this.fraudClient = fraudClient;
    }

    public void registerCustomer(Customer customer) {
        customer = customerRepository.saveCustomer(customer);
        // check email

        // check if fraudster
        fraudClient.isFraudster(customer.getId());

        // send notification
        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(),
                        customer.getEmail(),
                        "Welcome to nameless corp",
                        "Welcome to nameless corp " + customer.getFirstName() + " " + customer.getLastName() + ".");

//        rabbitMQMessageProducer.publish(
//                notificationRequest,
//                "internal.exchange",
//                "internal.notification.routing-key"
//        );
        kafkaProducer.publishMessage("notifications", notificationRequest);
    }
}
