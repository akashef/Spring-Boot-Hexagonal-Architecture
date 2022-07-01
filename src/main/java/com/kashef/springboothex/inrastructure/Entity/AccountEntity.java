package com.kashef.springboothex.inrastructure.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private BigDecimal accountBalance;

    @Column
    private long accountNo;

}
