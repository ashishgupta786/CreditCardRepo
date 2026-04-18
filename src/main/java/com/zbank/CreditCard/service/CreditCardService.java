package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.CreditCardResponse;

public interface CreditCardService {
    CreditCardResponse applyCard(String customerId);
}
