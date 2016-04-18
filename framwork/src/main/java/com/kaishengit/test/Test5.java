package com.kaishengit.test;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.spring.dao.IuserDao;
import com.kaishengit.spring.dao.UserDao;
import com.kaishengit.spring.service.UserService;
import com.kaishengit.util.SqlSessinUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by qiyawei on 2016/3/30.
 */
public class Test5 {
    public static void main(String[] args) {
        SqlSessionFactory sessionFactory=  SqlSessinUtil.sessionFactory;
        SqlSessionFactory sessionFactory1=  SqlSessinUtil.sessionFactory;



//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
//        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
//        Admin admin = adminDao.findById1(1);
//        System.out.println(admin.getName());
        //adminDao.delete(16);
       /* List<Admin> list = adminDao.findAll1();
        System.out.println(list.size())*/;
      /*  List<Admin> list = adminDao.findAll();
        System.out.println(list.size());*/
       /* Admin admin = new Admin();
        admin.setName("kkkk");
        admin.setPwd("7777777");
        adminDao.save1(admin);
*/




        /*UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
*/
       /* UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();*/
//        UserDao userDao1= (UserDao) applicationContext.getBean("userDao");
//        userDao1.save();
//        System.out.println(userDao == userDao1);
        //userDao.find();






      /*  UserService service = (UserService) applicationContext.getBean("userService");
        service.save();*/
       // UserDao userDao = (UserDao) applicationContext.getBean("userDao");
       // UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        //userDao1.save();
    }
}
