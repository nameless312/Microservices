package com.nameless.infra;

import org.nameless.customer.core.Customer;
import org.nameless.customer.infra.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerJPARepositoryImpl implements CustomerRepository {
    private final CustomerJPARepository customerJPARepository;

    public CustomerJPARepositoryImpl(@Lazy CustomerJPARepository customerJPARepository) {
        this.customerJPARepository = customerJPARepository;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerJPARepository.save(mapToEntity(customer));
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
