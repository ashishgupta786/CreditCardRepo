package com.zbank.CreditCard.entity;

import com.zbank.CreditCard.enums.CreditCardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credit_cards")
@Getter
@Setter
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    private String cardNumber;
    private String cardType;
    private Double creditLimit;

    private String pin;
    private boolean isPinChanged;

    private String status; // APPROVED / REJECTED / PENDING_DOCS

    @ManyToOne
    private Customer customer;

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public String getPin() {
        return pin;
    }

    public boolean isPinChanged() {
        return isPinChanged;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setPinChanged(boolean pinChanged) {
        isPinChanged = pinChanged;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
