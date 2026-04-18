package com.zbank.CreditCard.repository;

import com.zbank.CreditCard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(String id);
    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);

}