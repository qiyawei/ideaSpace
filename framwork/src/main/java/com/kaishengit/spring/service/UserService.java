package com.kaishengit.spring.service;

import com.kaishengit.spring.dao.BookDao;
import com.kaishengit.spring.dao.IuserDao;
import com.kaishengit.spring.dao.UserDao;

/**
 * Created by qiyawei on 2016/3/30.
 */
public class UserService {
    private IuserDao userDao;
    private BookDao bookDao;

    public UserService(BookDao bookDao,UserDao userDao1){
        this.userDao = userDao1;
        this.bookDao = bookDao;
    }

    public void save(){
        userDao.save();
        bookDao.save();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
