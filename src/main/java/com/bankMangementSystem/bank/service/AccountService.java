package com.bankMangementSystem.bank.service;


import com.bankMangementSystem.bank.entity.Account;

import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber , Double amount);
    public Account withdrwaAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
