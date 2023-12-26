package org.nameless.infra;

import org.nameless.core.customer.Customer;
import org.nameless.infra.customer.CustomerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerJPARepositoryImpl implements CustomerRepository {
    private final CustomerJPARepository customerJPARepository;

    public CustomerJPARepositoryImpl(@Lazy CustomerJPARepository customerJPARepository) {
        this.customerJPARepository = customerJPARepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = customerJPARepository.saveAndFlush(mapToEntity(customer));
        return mapToDomainModel(customerEntity);
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        CustomerEntity customerEntity = customerJPARepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToDomainModel(customerEntity);
    }

    private CustomerEntity mapToEntity(Customer customer) {
        return CustomerEntity.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    private Customer mapToDomainModel(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.id)
                .firstName(customerEntity.firstName)
                .lastName(customerEntity.lastName)
                .email(customerEntity.email)
                .build();
    }
}
