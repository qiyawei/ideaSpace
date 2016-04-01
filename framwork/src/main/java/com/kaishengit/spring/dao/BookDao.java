package com.kaishengit.spring.dao;

/**
 * Created by qiyawei on 2016/3/30.
 */
public class BookDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("book save......");
    }
}
