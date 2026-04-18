package com.zbank.CreditCard.dto;

import lombok.Data;

@Data
public class CustomerRegisterRequest {

    private String name;

    private String email;

    private String password;

    private String employmentType;
    private Double annualSalary;

    private String identityDocName;
    private String identityDocNumber;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
}