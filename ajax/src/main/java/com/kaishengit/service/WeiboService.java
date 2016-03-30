package com.kaishengit.service;

import com.kaishengit.dao.WeiboDao;
import com.kaishengit.enty.Weibo;

import java.util.List;

public class WeiboService {

    private WeiboDao dao = new WeiboDao();

    public List<Weibo> findAll() {
        return dao.findAll();
    }

    public List<Weibo> findByMaxId(Integer id) {
        return dao.count(id);
    }
}
