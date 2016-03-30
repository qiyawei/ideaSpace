package com.kaishengit.test;

import com.kaishengit.entity.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by qiyawei on 2016/3/23.
 */
public class Test1 {
    public static void main(String[] args)throws Exception{
        //读取mybatis.xml配置文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //操作数据库
        Admin admin = sqlSession.selectOne("com.kaishengit.dao.AdminMapper.findById",2);
        System.out.println(admin.getName());

        sqlSession.close();

    }
}
