package com.example;

import com.example.config.SpringConfiguration;
import com.example.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class JdbcTemplateCrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update db2.`account` set balance =? where id=?",10000,8);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from db2.`account` where id = ?",7);
    }

    @Test
    public void testQueryAll(){
        List<Account> rs = jdbcTemplate.query("select * from db2.`account`", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(rs);
    }

    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from db2.`account` where id=?", new BeanPropertyRowMapper<Account>(Account.class), 6);
        System.out.println(account);
    }

    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from db2.`account`", Long.class);
        System.out.println(count);
    }
}
