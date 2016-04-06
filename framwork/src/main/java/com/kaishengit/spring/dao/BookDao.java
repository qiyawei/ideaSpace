package com.kaishengit.spring.dao;

import javax.inject.Named;

/**
 * Created by qiyawei on 2016/3/30.
 */
@Named
public class BookDao implements IuserDao {
    @Override
    public void save() {
        System.out.println("book save......");
    }
}
