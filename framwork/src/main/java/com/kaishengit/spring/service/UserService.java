package com.kaishengit.spring.service;

import com.kaishengit.spring.dao.BookDao;
import com.kaishengit.spring.dao.IuserDao;
import com.kaishengit.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

/**
 * Created by qiyawei on 2016/3/30.
 */
@Named
public class UserService {

    private IuserDao userDao;
    @Autowired
    public void setUserDao(IuserDao userDao) {
        this.userDao = userDao;
    }

    /* private BookDao bookDao;

        public UserService(BookDao bookDao,UserDao userDao){
            this.userDao = userDao;
            this.bookDao = bookDao;
        }
    */
    public void save(){
        userDao.save();
        //bookDao.save();
    }


 /*   public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }*/
}
