package com.kashef.springboothex.domain.port.incoming;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public interface Withdraw {
    boolean withdraw(Long accountNo, BigDecimal withdrawalAmount);
}
