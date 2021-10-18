package com.example.test;

import com.example.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    //测试scope属性
    @Test
    public void test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        // assert userDao1==userDao2; //单例情况下
        // assert userDao1!=userDao2; // 多例模式下
        System.out.println(userDao1);
        System.out.println(userDao2);
        app.close();
    }
}
