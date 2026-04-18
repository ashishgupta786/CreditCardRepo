package com.zbank.CreditCard.controller;

import com.zbank.CreditCard.entity.CreditCard;
import com.zbank.CreditCard.service.CreditRatingService;
import com.zbank.CreditCard.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/api/creditcard/v1",
        produces = "application/json"
)
public class CustomerController {

    @Autowired
    private CreditScoreService creditScoreService;

    @Autowired
    private CreditRatingService creditRatingService;

    @GetMapping("/internal/creditscore/{custId}")

    public long getCreditScore(@PathVariable String custId) {

        return creditScoreService.calculateScore(custId);
    }

    @GetMapping("/internal/creditrating/{custId}")
    public CreditCard getCreditRating(@PathVariable String custId) {

        return creditRatingService.calculateRating(custId);

    }


}
