package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


//标志该类是Spring的核心配置类

@Configuration
@ComponentScan("com.example") //<context:component-scan base-package="com.example"/>
@Import({DataSourceConfiguration.class}) //<import resource=""/>
public class SpringConfiguration {

}
