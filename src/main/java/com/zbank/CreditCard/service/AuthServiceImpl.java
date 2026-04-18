package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.AuthRequest;
import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.repository.CustomerRepository;
import com.zbank.CreditCard.utility.JwtUtil;

public class AuthServiceImpl implements AuthService{

    private CustomerRepository customerRepository;
 //   private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;


    @Override
    public String login(AuthRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

//        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
//            throw new RuntimeException("Invalid email or password");
//        }
        return jwtUtil.generateToken(customer.getEmail());
    }
}
