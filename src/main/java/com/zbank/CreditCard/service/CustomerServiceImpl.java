package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.CustomerRegisterRequest;
import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer register(CustomerRegisterRequest request) {

        // 1. Check duplicate email
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Map DTO → Entity
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        //customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setEmploymentType(request.getEmploymentType());
        customer.setAnnualSalary(request.getAnnualSalary());
        customer.setIdentityDocName(request.getIdentityDocName());
        customer.setIdentityDocNumber(request.getIdentityDocNumber());

       //  3. Save
        return customerRepository.save(customer);
    }
}