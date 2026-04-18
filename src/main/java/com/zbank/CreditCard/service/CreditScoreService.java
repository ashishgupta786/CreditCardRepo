package com.zbank.CreditCard.service;

import com.zbank.CreditCard.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService  {

    public int calculateScore(Customer customer) {
        if (customer.getAnnualSalary() > 200000) return 500;
        if (customer.getAnnualSalary() > 50000) return 150;

        return 50;
    }

}
