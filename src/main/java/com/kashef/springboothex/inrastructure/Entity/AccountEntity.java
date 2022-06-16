package com.kashef.springboothex.inrastructure.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer productId;

    @Column
    private BigDecimal accountBalance;

    @Column
    private long accountNo;

}
