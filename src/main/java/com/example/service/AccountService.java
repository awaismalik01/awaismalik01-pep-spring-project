package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.AccountCredentialsException;
import com.example.exception.AccountExistException;
import com.example.exception.AccountInvalidException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account userRegistration(Account account) throws AccountExistException, AccountInvalidException {

        if (account.getUsername().isEmpty() || account.getPassword().length() <= 4)
            throw new AccountInvalidException("Invalid username and password format");

        Account existingAcc = accountRepository.findByUsername(account.getUsername());
        if (existingAcc == null) {
            return accountRepository.save(account);
        } else {
            throw new AccountExistException("Account Already Exist");
        }
    }

    public Account userLogin(Account account) throws AccountCredentialsException {

        Account existingAcc = accountRepository.findByUsername(account.getUsername());

        // Get by username to decrypt password to characters and compare in Advance.

        if (existingAcc != null && existingAcc.getPassword().equals(account.getPassword())) {
            return existingAcc;
        } else {
            throw new AccountCredentialsException("Invalid Credentials");
        }
    }

}
