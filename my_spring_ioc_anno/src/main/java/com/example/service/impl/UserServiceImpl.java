package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/*<bean id="userService" class="com.example.service.impl.UserServiceImpl">

</bean>*/
//@Component("userService")   Service用在service层
@Service("userService")
//@Scope("prototype")
//@Scope("singleton")
public class UserServiceImpl implements UserService {

    //注入普通属性
    @Value("${jdbc.driverClassName}")
    private String driver;

    // <property name="userDao" ref="userDao"/>
    // 注入
    //@Autowired  //只写Autowired，按照数据类型从Spring容器中进行匹配
    //@Qualifier("userDao")  //按照id值从容器中进行匹配，此处@Qualifier结合@Autowired一起使用
    @Resource(name = "userDao")  //@Resource 相当于@Qualifier+@Autowired
    private  UserDao userDao;
    //注解配置set可省略
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service对象初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Service对象的销毁方法");
    }
}
