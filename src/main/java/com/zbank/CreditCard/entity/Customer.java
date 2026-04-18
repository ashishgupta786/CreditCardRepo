package com.zbank.CreditCard.entity;

import com.zbank.CreditCard.CreditCardApplication;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {


    @Id
    @GeneratedValue
    private Long id;

    private Long custId;

    private String name;
    private String email;

    private int existingCards;

    private String employmentType;
    private Double annualSalary;

    private long creditScore;

    private String identityDocName;
    private String identityDocNumber;
}