package org.nameless.application;
import lombok.extern.slf4j.Slf4j;
import org.nameless.core.customer.Customer;
import org.nameless.core.customer.CustomerService;
import org.nameless.infra.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(Customer customer) {
        customer = customerRepository.saveCustomer(customer);
        // check email

        // check if fraudster
        restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                Object.class,
                customer.getId());
    }
}
