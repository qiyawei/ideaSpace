package com.kaishengit.spring.dao;

public class UserDao implements IUserDao {
    public void init(){
        System.out.println("init.....");

    }
    public void destroy(){
        System.out.println("destror.......");
    }
    public UserDao(){
        System.out.println("userDao 创建了");
    }
    public void save(){
        System.out.println("user save......");
    }
}
