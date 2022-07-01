package com.kashef.springboothex.domain.model;


import java.math.BigDecimal;


public class Account {

    private long accountNo;
    private BigDecimal accountBalance;

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean withdrawAmount(BigDecimal withdrawalAmount) {
        if (accountBalance.compareTo(withdrawalAmount) < 0) {
            return false;
        }
        accountBalance = accountBalance.subtract(withdrawalAmount);
        return true;
    }

    public void depositAmount(BigDecimal depositAmount) {
        accountBalance = accountBalance.add(depositAmount);
    }

}
