package com.kaishengit.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.kaishengit.exception.DataAccessException;

public class ConnectionManager {

    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static BasicDataSource dataSource = new BasicDataSource();

    static {

        //读取db.properties文件
        Properties prop = new Properties();
        try {
            prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("db.properties"));
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }



        //数据源
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(5000);
    }

    /**
     * 获取DataSource对象
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e1) {
            throw new DataAccessException("获取数据库连接池错误",e1);
        }
    }


}
