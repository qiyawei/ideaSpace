package com.kaishengit.util;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DbHelp {

    public static void executeUpdate(String sql,Object...params) {
        QueryRunner runner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            runner.update(sql,params);
            System.out.println("SQL:" + sql);
        } catch (SQLException e) {
            throw new DataAccessException("执行["+sql+"]异常",e);
        }
    }

    public static <T> T query(String sql,ResultSetHandler<T> handler,Object... params) {
        QueryRunner runner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            T t = runner.query(sql, handler, params);
            System.out.println("SQL:" + sql);
            return t;
        } catch (SQLException e) {
            throw new DataAccessException("执行["+sql+"]异常",e);
        }
    }
}
