package com.kashef.springboothex.inrastructure.adapter;

import com.kashef.springboothex.domain.model.Account;
import com.kashef.springboothex.domain.port.outgoing.PersistAccount;
import com.kashef.springboothex.domain.port.outgoing.RetrieveAccount;
import com.kashef.springboothex.inrastructure.Entity.AccountEntity;
import com.kashef.springboothex.inrastructure.repository.SpringDataAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountAdapter implements RetrieveAccount, PersistAccount {

    private SpringDataAccountRepository repository;

    public AccountAdapter(SpringDataAccountRepository repository) {
        this.repository = repository;
    }

    public Account load(Long accountNo) {
        var result =  repository.findById(accountNo);
        AccountEntity accountEntity = result.get();
        Account account = new Account();
        BeanUtils.copyProperties(accountEntity, account);
        return account;
    }

    public void save(Account bankAccount) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(bankAccount, accountEntity);
        repository.save(accountEntity);
    }}
