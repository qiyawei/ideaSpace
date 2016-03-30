package com.kaishengit.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
    public static void main(String[] args) throws Exception {
       /* DELIMITER //
        CREATE PROCEDURE SAVE(IN a VARCHAR(20),in b VARCHAR(20))
        BEGIN
        INSERT INTO admin(`name`,pwd) VALUES(a,b);
        END//
        DELIMITER;*/
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db_20","root","123123");
        CallableStatement statement = connection.prepareCall("{call save(?,?)}");
        statement.setObject(1,"lucy");
        statement.setObject(2,"456456");
        statement.executeUpdate();
    }
}
