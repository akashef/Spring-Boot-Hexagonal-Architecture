package com.kashef.springboothex.domain.port.outgoing;

import com.kashef.springboothex.domain.model.Account;

import java.util.Optional;

public interface RetrieveAccount {
    Account load(Long accountNo);
}
