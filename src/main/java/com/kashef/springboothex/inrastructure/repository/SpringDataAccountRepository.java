package com.kashef.springboothex.inrastructure.repository;

import com.kashef.springboothex.domain.model.Account;
import com.kashef.springboothex.inrastructure.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

public interface SpringDataAccountRepository extends CrudRepository<AccountEntity, Long> {

}

