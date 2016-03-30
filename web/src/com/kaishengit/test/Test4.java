package com.kaishengit.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * Created by qiyawei on 2016/3/23.
 */
public class Test4 {
  /*  delimiter//
    CREATE PROCEDURE getScore4(out rescore FLOAT(4,2),out `rename` varchar(50), in n INT(3))
    BEGIN
    select score into rescore from result where id=n;
    select studentno into `rename` from result where id=n;
    end //
     delimiter;*/
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db_20", "root", "123123");
        CallableStatement statement = connection.prepareCall("{call getScore4(?,?,?)}");
        //注册第几个参数是返回值
        statement.registerOutParameter(1, Types.FLOAT);
        statement.registerOutParameter(2,Types.CHAR);
        //给参数赋值
        statement.setObject(3,5);
        statement.executeUpdate();
        Float f = statement.getFloat(1);
        String str = statement.getString(2);
        System.out.println(f +": " + str);
    }

}
