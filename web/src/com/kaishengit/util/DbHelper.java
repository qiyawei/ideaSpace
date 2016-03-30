package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.kaishengit.exception.DataException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DbHelper {
	
 
	/**
	 * ���ӣ��޸ģ�ɾ��
	 * @param sql
	 */
	public static  void update(String sql,Object...params){
		QueryRunner runner = new QueryRunner();
		Connection conn = ConnectionManager.getConnection();
		try {
			runner.update(conn, sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e,"执行sql[" + sql + "]异常" );
		}/*finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataException(e,"执行sql[" + sql + "]异常" );
			}
		}*/
	}
	/**
	 * ��ѯ
	 * @return
	 */
	public static <T> T query(String sql,ResultSetHandler<T> handler,Object...params){
		
		QueryRunner runner = new QueryRunner(ConnectionManager.getDatasource());

		try {
			T t = runner.query( sql, handler, params);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e,"执行sql[" + sql + "]异常" );

		}/*finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataException(e,"执行sql[" + sql + "]异常" );
			}
		}*/
		
	}
	
}
