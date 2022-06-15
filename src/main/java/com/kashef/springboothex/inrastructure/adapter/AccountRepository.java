package com.kashef.springboothex.inrastructure.adapter;

import com.kashef.springboothex.domain.model.Account;
import com.kashef.springboothex.domain.port.outgoing.PersistAccount;
import com.kashef.springboothex.domain.port.outgoing.RetrieveAccount;
import org.springframework.stereotype.Component;


@Component
public class AccountRepository implements RetrieveAccount, PersistAccount {
    private SpringDataAccountRepository repository;

    public AccountRepository(SpringDataAccountRepository repository) {
        this.repository = repository;
    }

    public Account load(Long accountNo) {
        return repository.findByAccountNo(accountNo);
    }

    public void save(Account bankAccount) {
        repository.save(bankAccount);
    }}
