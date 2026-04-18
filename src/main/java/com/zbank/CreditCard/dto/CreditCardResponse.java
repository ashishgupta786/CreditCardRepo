package com.zbank.CreditCard.dto;

public class CreditCardResponse {
    private String cardNumber;
    private String cardType;
    private Double limit;
    private String status;
    private String message;

//    {
//        "cardNumber": "1234567890123456",
//            "cardType": "PLATINUM",
//            "limit": 40000,
//            "status": "APPROVED",
//            "message": "Card approved successfully. Please login and change PIN."
//    }

    public CreditCardResponse(String cardNumber, String cardType, Double limit, String status, String message) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.limit = limit;
        this.status = status;
        this.message = message;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public Double getLimit() {
        return limit;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
