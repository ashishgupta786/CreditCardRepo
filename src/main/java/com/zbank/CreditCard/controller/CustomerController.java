package com.zbank.CreditCard.controller;

import com.zbank.CreditCard.dto.CustomerRegisterRequest;
import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerRegisterRequest request) {
        Customer customer = customerService.register(request);
        return ResponseEntity.ok(Map.of(
                "message", "Customer registered successfully",
                "customerId", customer.getId()
        ));
    }
}
