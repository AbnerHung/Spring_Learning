package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;


//标志该类是Spring的核心配置类

@Configuration
@ComponentScan("com.example") //<context:component-scan base-package="com.example"/>
@Import({DataSourceConfiguration.class}) //<import resource=""/>
public class SpringConfiguration {

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
