package com.kashef.springboothex.application.controller;

import com.kashef.springboothex.domain.port.incoming.Deposit;
import com.kashef.springboothex.domain.port.incoming.Withdraw;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController implements Deposit, Withdraw {
    private final Deposit depositUseCase;
    private final Withdraw withdrawUseCase;

    public AccountController(Deposit depositUseCase, Withdraw withdrawUseCase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    @PostMapping(value = "/{accountNo}/deposit/{depositAmount}")
    public void deposit(@PathVariable final Long accountNo, @PathVariable final BigDecimal depositAmount) {
        depositUseCase.deposit(accountNo, depositAmount);
    }

    @PostMapping(value = "/{accountNo}/withdraw/{withdrawalAmount}")
    public boolean withdraw(@PathVariable final Long accountNo, @PathVariable final BigDecimal withdrawalAmount) {
        withdrawUseCase.withdraw(accountNo, withdrawalAmount);
        return false;
    }
}
