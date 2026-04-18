package com.zbank.CreditCard.controller;

import com.zbank.CreditCard.dto.CreditCardResponse;
import com.zbank.CreditCard.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CreditCardController {

    private  CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("/apply")
    public ResponseEntity<CreditCardResponse> applyCard(@RequestBody String customerId) {
        return ResponseEntity.ok(creditCardService.applyCard(customerId));
    }
}