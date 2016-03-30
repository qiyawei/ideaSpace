package com.kaishengit.test;

import com.kaishengit.spring.dao.UserDao;
import com.kaishengit.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiyawei on 2016/3/30.
 */
public class Test5 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService service = (UserService) applicationContext.getBean("userService");
        service.save();
       // UserDao userDao = (UserDao) applicationContext.getBean("userDao");
       // UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        //userDao1.save();
    }
}
