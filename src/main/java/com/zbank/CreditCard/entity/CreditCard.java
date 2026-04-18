package com.zbank.CreditCard.entity;

import com.zbank.CreditCard.dto.Status;
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

    @Enumerated(EnumType.STRING)
    private Status status; // APPROVED / REJECTED / PENDING_DOCS

    @ManyToOne
    private Customer customer;
}
