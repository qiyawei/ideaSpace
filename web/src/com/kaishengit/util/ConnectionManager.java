package com.kaishengit.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	/*private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///mydb?characterEncoding=UTF-8&useUnicode=true";
	private static final String USERNAME = "tom";
	private static final String PASSWORD = "123456";*/
	private static BasicDataSource dataSource = new BasicDataSource();


	static {
		Properties prop = new Properties();
		try {
			prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("db.properties"));
			dataSource.setDriverClassName(prop.getProperty("jdbc.driver"));
			dataSource.setUsername(prop.getProperty("jdbc.username"));
			dataSource.setPassword(prop.getProperty("jdbc.password"));
			dataSource.setUrl(prop.getProperty("jdbc.url"));

			dataSource.setInitialSize(5);
			dataSource.setMinIdle(5);
			dataSource.setMaxIdle(10);
			dataSource.setMaxWait(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  null;
	}

	public static DataSource getDatasource() {
		return dataSource;
	}

	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	/*public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
*/

}
