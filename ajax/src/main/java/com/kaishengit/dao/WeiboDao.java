package com.kaishengit.dao;

import com.kaishengit.enty.Weibo;
import com.kaishengit.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class WeiboDao {

    public List<Weibo> findAll() {
        String sql = "select * from weibo order by id desc";
        return DbHelp.query(sql,new BeanListHandler<Weibo>(Weibo.class));
    }


    public List<Weibo> count(Integer id) {
        String sql = "select * from weibo where id > ?";
        return DbHelp.query(sql,new BeanListHandler<Weibo>(Weibo.class),id);
    }
}
