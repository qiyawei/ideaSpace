package com.kaishengit.spring.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

@Named
public class UserDao implements IuserDao{
//    public UserDao(){
//        System.out.println(111);
//    }
   /* public void init(){
        System.out.println("init.....");

    }
    public void destroy(){
        System.out.println("destror.......");
    }
    public UserDao(){
        System.out.println("userDao 创建了");
    }*/
    public void save(){
        System.out.println("user save......");
       // throw new RuntimeException("出异常了");
    }
    public  String find(){
        return "string";
    }
}
