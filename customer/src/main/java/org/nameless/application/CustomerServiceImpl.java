package org.nameless.application;
import lombok.extern.slf4j.Slf4j;
import org.nameless.core.customer.Customer;
import org.nameless.core.customer.CustomerService;
import org.nameless.fraud.FraudClient;
import org.nameless.infra.customer.CustomerRepository;
import org.nameless.notification.NotificationClient;
import org.nameless.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final NotificationClient noficationClient;
    private final FraudClient fraudClient;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               NotificationClient noficationClient,
                               FraudClient fraudClient) {
        this.customerRepository = customerRepository;
        this.noficationClient = noficationClient;
        this.fraudClient = fraudClient;
    }

    public void registerCustomer(Customer customer) {
        customer = customerRepository.saveCustomer(customer);
        // check email

        // check if fraudster
        fraudClient.isFraudster(customer.getId());

        // send notification
        noficationClient.sendNotification(
                new NotificationRequest(customer.getId(), customer.getEmail(), "Hi there mr.")
        );
    }
}
