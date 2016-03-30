package com.kaishengit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DbHelper2 {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///mydb?characterEncoding=UTF-8&useUnicode=true";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	
	/**
	 * ��ȡ����
	 */
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * ���� ɾ�� �޸�
	 */
	
	public void update(String sql,Object...params){
		Connection conn = getConnection();
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			connClose(conn);
		}
	}
	/**
	 * ��ѯ
	 * @param conn
	 */
	public <T> T query(String sql,ResultSetHandler<T> handler,Object...params){
		Connection conn = getConnection();
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(conn,sql,handler,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			connClose(conn);
		}
		return null;
	}
	/**
	 * �ر�����
	 * @param conn
	 */
	private void connClose(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
