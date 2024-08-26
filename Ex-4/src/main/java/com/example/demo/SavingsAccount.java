package com.example.demo;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
    private final static double MINIMUM_BALANCE = 500.0;

    public SavingsAccount() {}

    public SavingsAccount(String name, double balance) {
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
