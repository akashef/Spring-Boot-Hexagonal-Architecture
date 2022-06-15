package com.kashef.springboothex.domain.port.incoming;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

public interface Deposit {
    void deposit(Long accountNo, BigDecimal depositAmount);
}
