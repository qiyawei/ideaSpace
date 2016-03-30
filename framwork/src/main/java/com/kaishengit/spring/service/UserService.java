package com.kaishengit.spring.service;

import com.kaishengit.spring.dao.UserDao;

/**
 * Created by qiyawei on 2016/3/30.
 */
public class UserService {
    private UserDao userDao;

    public void save(){
        userDao.save();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
