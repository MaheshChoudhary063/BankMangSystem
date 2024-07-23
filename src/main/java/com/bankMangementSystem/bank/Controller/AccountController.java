package com.bankMangementSystem.bank.Controller;


import com.bankMangementSystem.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bankMangementSystem.bank.entity.Account;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createAccount =service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }


    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable Long accountNumber){
        Account account=service.getAccountDetailsByAccountNumber(accountNumber);
        return account;
    }

    @GetMapping("/getallaccount")
    public List<Account> getAllAccountDetails(){
        List<Account> allAccountDetails=service.getAllAccountDetails();
        return allAccountDetails;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = service.depositAmount(accountNumber,amount);
        return account;
    }

    @PutMapping("/withdrwa/{accountNumber}/{amount}")
    public Account withdrwaAmount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = service.withdrwaAmount(accountNumber,amount);
        return account;
    }

    @DeleteMapping("/close/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
        return ResponseEntity.ok("Account clodes");
    }
}
