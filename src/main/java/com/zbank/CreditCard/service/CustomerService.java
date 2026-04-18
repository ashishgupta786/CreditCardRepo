package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.CustomerRegisterRequest;
import com.zbank.CreditCard.entity.Customer;

public interface CustomerService {
    Customer register(CustomerRegisterRequest request);
}
