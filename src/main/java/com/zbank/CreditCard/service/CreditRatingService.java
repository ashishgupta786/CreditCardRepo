package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.Status;
import com.zbank.CreditCard.entity.CreditCard;
import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    public CreditCard calculateRating(String custId) {

        Long id = Long.parseLong(custId);
        Customer customer = customerRepository.findByCustId(id);

        long score = customer.getCreditScore();

        CreditCard creditCard = null;

        if (score == 500) {
            creditCard.setCardType("PLATANIUM");
            creditCard.setCreditLimit(40000.00);
        }
        if (score == 300) {
            creditCard.setCardType("GOLD");
            creditCard.setCreditLimit(20000.00);
        }
        if (score == 150) {
            creditCard.setCardType("VISA");
            creditCard.setCreditLimit(10000.00);
        }
        if (score == 50) {
            creditCard.setStatus(Status.PENDING_DOCS);
        }
        return creditCard;
    }

}
