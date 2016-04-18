package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by qiyawei on 2016/3/23.
 */
public class SqlSessinUtil {
    //public static int a;
    private static SqlSessionFactory sessionFactory = buildSessionFactory();

    private static SqlSessionFactory buildSessionFactory() {
        System.out.println(1111);
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            return new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static SqlSession getSqlSession(){
        return sessionFactory.openSession();
    }
    public static SqlSession getSqlSession(Boolean bool){
        return sessionFactory.openSession(bool);
    }
}
