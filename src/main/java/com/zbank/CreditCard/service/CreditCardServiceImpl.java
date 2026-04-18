package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.CreditCardResponse;
import com.zbank.CreditCard.entity.CreditCard;
import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.repository.CreditCardRepository;
import com.zbank.CreditCard.repository.CustomerRepository;

public class CreditCardServiceImpl implements CreditCardService {
    private CustomerRepository customerRepository;
    private CreditCardRepository cardRepository;
    private CreditScoreService creditScoreService;
    private DecisionService decisionService;

    @Override
    public CreditCardResponse applyCard(String customerId) {
        // 1. Fetch customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        // 3. Calculate score
        int score = creditScoreService.calculateScore(customer);
        // 4. Decision
        CreditCard card = decisionService.createCard(customer, score);
        // 5. Save
        cardRepository.save(card);
        // 6. Response
        return buildResponse(card);
    }

    private CreditCardResponse buildResponse(CreditCard card) {
            if (card.getStatus() == "PENDING_DOCS") {
                return new CreditCardResponse(
                        null,
                        null,
                        null,
                        "PENDING_DOCS",
                        "Please provide additional documents"
                );
            }

        return new CreditCardResponse(
                card.getCardNumber(),
                card.getCardType(),
                card.getCreditLimit(),"",
                "Card approved successfully. Please login and change PIN."
        );
    }

}
