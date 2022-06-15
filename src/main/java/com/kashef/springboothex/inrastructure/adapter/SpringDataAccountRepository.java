package com.kashef.springboothex.inrastructure.adapter;

import com.kashef.springboothex.domain.model.Account;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SpringDataAccountRepository extends JdbcDaoSupport{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public Account findByAccountNo(Long accountNo) {
        String sql = "SELECT * FROM account WHERE accountNo = ?";
        return (Account) getJdbcTemplate().queryForObject(sql, new Object[] { accountNo }, new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Account account = new Account();
                account.setAccountNo(rs.getLong("accountNo"));
                account.setAccountBalance(rs.getBigDecimal("balance"));
                return account;
            }
        });
    }

    public void save(Account bankAccount) {
        String sql = "UPDATE account SET " + "balance= ? WHERE accountNo = ?";
        getJdbcTemplate().update(sql, new Object[] { bankAccount.getAccountBalance(), bankAccount.getAccountNo() });
    }
}
