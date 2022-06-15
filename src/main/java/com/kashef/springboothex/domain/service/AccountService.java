package com.kashef.springboothex.domain.service;

import com.kashef.springboothex.domain.model.Account;
import com.kashef.springboothex.domain.port.outgoing.PersistAccount;
import com.kashef.springboothex.domain.port.outgoing.RetrieveAccount;

import java.math.BigDecimal;

public class AccountService {
    private RetrieveAccount retrieveAccount;
    private PersistAccount persistAccount;

    public AccountService(RetrieveAccount retrieveAccount, PersistAccount persistAccount) {
        this.retrieveAccount = retrieveAccount;
        this.persistAccount = persistAccount;
    }

    public void deposit(Long accountNo, BigDecimal depositAmount) {
        Account account = retrieveAccount.load(accountNo);
        account.depositAmount(depositAmount);
        persistAccount.save(account);
    }

    public boolean withdraw(Long accountNo, BigDecimal withdrawalAmount) {
        Account account = retrieveAccount.load(accountNo);
        boolean withdrawSucess = account.withdrawAmount(withdrawalAmount);

        if (withdrawSucess) {
            persistAccount.save(account);
        }
        return withdrawSucess;
    }
}
