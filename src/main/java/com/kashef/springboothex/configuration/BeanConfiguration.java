package com.kashef.springboothex.configuration;

import com.kashef.springboothex.SpringBootHexApplication;
import com.kashef.springboothex.domain.service.AccountService;
import com.kashef.springboothex.inrastructure.adapter.AccountAdapter;
import com.kashef.springboothex.inrastructure.repository.SpringDataAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringBootHexApplication.class)
public class BeanConfiguration {

    @Bean
    AccountService bankAccountService(AccountAdapter repository)
    {
        return new AccountService(repository, repository);
    }

}
