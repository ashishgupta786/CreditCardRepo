package com.zbank.CreditCard.service;

import com.zbank.CreditCard.entity.CreditCard;
import com.zbank.CreditCard.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class DecisionService {

    public CreditCard createCard(Customer customer, int score) {

        CreditCard card = new CreditCard();
        card.setCustomer(customer);
        if (score == 500) {
            card.setCardType("PLATINUM");
            card.setCreditLimit(40000.0);
            card.setStatus("APPROVED");

        } else if (score == 300) {
            card.setCardType("GOLD");
            card.setCreditLimit(20000.0);
            card.setStatus("APPROVED");
        } else if (score == 150) {
            card.setCardType("VISA");
            card.setCreditLimit(10000.0);
            card.setStatus("APPROVED");
        } else {
            card.setStatus("PENDING");
            return card;
        }

        card.setCardNumber(generateCardNumber());
        card.setPin(generatePin());
        card.setPinChanged(false);

        return card;
    }

    private String generateCardNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    private String generatePin() {
        return String.valueOf(new Random().nextInt(9000) + 1000);
    }
}