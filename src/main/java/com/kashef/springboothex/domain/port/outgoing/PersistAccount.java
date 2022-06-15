package com.kashef.springboothex.domain.port.outgoing;

import com.kashef.springboothex.domain.model.Account;

public interface PersistAccount {
    void save(Account account);
}
