package com.kaishengit.test;

import java.sql.*;

public class Test5 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db_20","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    //开启事务

        try {

            connection.setAutoCommit(false);
            String sql1 = "insert into user(username) value(?)";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,"jim1");
            statement.executeUpdate();

            Savepoint sp = connection.setSavepoint();

            String sql2 = "inserts into user(username) value(?)";
            statement = connection.prepareStatement(sql2);
            statement.setObject(1,"jim2");
            statement.executeUpdate();

            String sql3 = "insert into user(username) value(?)";
            statement = connection.prepareStatement(sql3);
            statement.setObject(1,"jim3");
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


    }
}
