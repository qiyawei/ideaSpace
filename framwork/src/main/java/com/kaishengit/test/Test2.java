package com.kaishengit.test;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.SqlSessinUtil;
import org.apache.ibatis.session.SqlSession;

public class Test2 {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessinUtil.getSqlSession(true);
        //sqlSession.delete("com.kaishengit.dao.AdminMapper.del",4);
       Admin admin = sqlSession.selectOne("com.kaishengit.dao.AdminMapper.findById", 1);
        //Admin admin = new Admin();
        admin.setName("ll");
        admin.setPwd("789789");
        sqlSession.insert("com.kaishengit.dao.AdminMapper.update",admin);
        //sqlSession.commit();
        sqlSession.close();
    }
}
