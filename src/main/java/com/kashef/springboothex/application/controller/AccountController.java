package com.kashef.springboothex.application.controller;

import com.kashef.springboothex.domain.port.incoming.Deposit;
import com.kashef.springboothex.domain.port.incoming.Withdraw;
import com.kashef.springboothex.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController implements Deposit, Withdraw {
    @Autowired
    public AccountService accountService;

    @PostMapping(value = "/{accountNo}/deposit/{depositAmount}")
    public void deposit(@PathVariable final Long accountNo, @PathVariable final BigDecimal depositAmount) {
        accountService.deposit(accountNo, depositAmount);
    }

    @PostMapping(value = "/{accountNo}/withdraw/{withdrawalAmount}")
    public boolean withdraw(@PathVariable final Long accountNo, @PathVariable final BigDecimal withdrawalAmount) {
        accountService.withdraw(accountNo, withdrawalAmount);
        return false;
    }

    @GetMapping(value = "hello")
    public String hello() {
         return "hello";
    }
}
