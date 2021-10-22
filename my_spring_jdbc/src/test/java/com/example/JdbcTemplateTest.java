package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.example.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.SQLException;


public class JdbcTemplateTest {

    //测试JdbcTemplate开发步骤
    @Test
    public void test1() throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //创建数据源
        //DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        //设置数据源对象,拿到connection对象
        //jdbcTemplate.setDataSource(dataSource);

        int a = jdbcTemplate.update("insert into `db2`.`account` values (?,?,?);",8,"LyH",6666666.66);

        System.out.println(a);
    }


}
