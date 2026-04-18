package com.zbank.CreditCard.service;

import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.exception.CustomerNotFoundException;
import com.zbank.CreditCard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    @Autowired
    private CustomerRepository customerRepository;

    public long calculateScore(String custId) {

        Customer customer = customerRepository.findByCustId(custId);

        long existingCards = customer.getId();

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        double salary = customer.getAnnualSalary();

        long creditScore = customer.getCreditScore();

        if (existingCards >= 2) {
            creditScore = 300;
        }
        if (salary > 200000) {
            creditScore = 500;
        }
        if (salary < 200000 && salary > 50000) {
            creditScore = 150;
        }
        if (salary < 50000) {

            creditScore = 50;
        }
        customer.setCreditScore(creditScore);

        return creditScore;
    }
}
