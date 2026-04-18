package com.zbank.CreditCard.service;

import com.zbank.CreditCard.entity.Customer;

public class CreditScoreService {

    public int calculateScore(Customer customer, int existingCards) {
        if (existingCards >= 2) return 300;
        if (customer.getAnnualSalary() > 200000) return 500;
        if (customer.getAnnualSalary() > 50000) return 150;
        return 50;
    }
}
