package com.example.demo;

import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
    private final static double MINIMUM_BALANCE = 1000.0;

    public CurrentAccount() {}

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MINIMUM_BALANCE) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}