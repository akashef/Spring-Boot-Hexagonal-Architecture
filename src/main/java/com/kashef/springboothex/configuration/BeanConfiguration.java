package com.kashef.springboothex.configuration;

import com.kashef.springboothex.SpringBootHexApplication;
import com.kashef.springboothex.domain.service.AccountService;
import com.kashef.springboothex.inrastructure.adapter.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringBootHexApplication.class)
@ComponentScan(basePackages = {"com.kashef.springboothex.domain.port"})
public class BeanConfiguration {

    @Bean
    AccountService bankAccountService(AccountRepository repository) {
        return new AccountService(repository, repository);
    }

}
