package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(int accountNumber) {
        return accountRepository.findById(accountNumber);
    }

    public void deleteAccount(int accountNumber) {
        accountRepository.deleteById(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isPresent()) {
            Account acc = account.get();
            acc.deposit(amount);
            accountRepository.save(acc);
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isPresent()) {
            Account acc = account.get();
            acc.withdraw(amount);
            accountRepository.save(acc);
        } else {
            throw new RuntimeException("Account not found");
        }
    }
}
