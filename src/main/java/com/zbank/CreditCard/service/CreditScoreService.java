package com.zbank.CreditCard.service;

import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.exception.CustomerNotFoundException;
import com.zbank.CreditCard.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditScoreService {

    @Autowired
    private CustomerRepository customerRepository;

    public long calculateScore(String custId) {

        Long id = Long.parseLong(custId);
        log.debug("Id value: "+id);
        Customer customer = customerRepository.findByCustId(id);

        long existingCards = customer.getExistingCards();

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        double salary = customer.getAnnualSalary();

        log.debug("Customer Salary: "+salary);

        long creditScore = customer.getCreditScore();

        log.debug("Credit score: "+creditScore);
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
