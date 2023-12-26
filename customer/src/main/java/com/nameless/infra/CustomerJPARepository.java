package com.nameless.infra;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Integer> {
}
