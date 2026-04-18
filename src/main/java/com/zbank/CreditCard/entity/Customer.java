package com.zbank.CreditCard.entity;

import com.zbank.CreditCard.CreditCardApplication;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Data
public class Customer {


    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String employmentType;
    private Double annualSalary;
    private String password;
    private String identityDocName;
    private String identityDocNumber;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public String getIdentityDocName() {
        return identityDocName;
    }

    public String getIdentityDocNumber() {
        return identityDocNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void setIdentityDocName(String identityDocName) {
        this.identityDocName = identityDocName;
    }

    public void setIdentityDocNumber(String identityDocNumber) {
        this.identityDocNumber = identityDocNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}