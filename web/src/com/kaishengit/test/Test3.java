package com.kaishengit.test;



import java.sql.*;

/**
 * Created by qiyawei on 2016/3/23.
 */
public class Test3 {
    public static void main(String[] args) throws Exception{
       /* delimiter//
        CREATE PROCEDURE getScore3(out rescore FLOAT(4,2),in n INT(3))
        BEGIN
        select score into rescore from result where id=n;
        end //
        delimiter;
        call getScore3(@a,20)
        SELECT @a*/

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db_20","root","123123");
        CallableStatement statement = connection.prepareCall("{call getScore3(?,?)}");
        statement.registerOutParameter(1, Types.FLOAT);
        statement.setObject(2,5);
        statement.executeUpdate();
        Float f = statement.getFloat(1);
        System.out.println(f);
    }
}
