package com.example.dao.impl;

import com.example.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//<bean id="userDao" class="com.example.dao.impl.UserDaoImpl"></bean>
//@Component("userDao") Repository用于dao层
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Save running...");
    }
}
