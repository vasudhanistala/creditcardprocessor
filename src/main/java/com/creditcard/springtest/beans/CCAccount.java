package com.creditcard.springtest.beans;

import com.creditcard.springtest.beans.validation.CardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CC_ACCOUNT")
public class CCAccount {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CC_ID")
    private Long Id;

    @NotNull
    @Column(name="CC_NUMBER")
    @CardNumber()
    String cardNumber;

    @NotNull
    @Column(name="CC_ACC_HOLDER_NAME")
    String customerName;

    @NotNull
    @Column(name="CC_LIMIT")
    Integer cardLimit;

    @Column(name="CC_BALANCE")
    Integer balance=0;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Integer limit) {
        this.cardLimit = limit;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "account{" +
                "Id=" + Id +
                ", cardNumber='" + cardNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", cardLimit=" + cardLimit +
                ", balance=" + balance +
                '}';
    }
}
