package com.kaishengit.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test1 {
    public static void main(String[] args) throws Exception{
       /* CREATE PROCEDURE avgscore1()
        BEGIN
        SELECT AVG(score) as avgscore FROM result;
        end //
        DELIMITER;*/
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db_20","root","123123");
        CallableStatement statement = conn.prepareCall("{call avgscore1}");
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            Float f = rs.getFloat("avgscore");
            System.out.println(f);
        }
        rs.close();
        statement.close();
        conn.close();
    }
}
