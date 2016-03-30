package com.kaishengit.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.entity.User;
import com.kaishengit.util.DbHelper;

public class UserDao {
	public User findByUsername(String username){
		String sql = "select *from t_user where username=?";
		return DbHelper.query(sql, new BeanHandler<User>(User.class), username);
	}
	/*public List<User> selcet(){
		String sql = "select *from t_user ";
		return DbHelper.query(sql, new BeanListHandler<User>(User.class));
	}
	public long selectSingle(){
		String sql ="select  Max(id) from t_user";
		return DbHelper.query(sql, new ScalarHandler<Long>());
	}
	
	public Map<String,Object> selectMap(String id){
		String sql ="select username,password from t_user where id =?";
		return DbHelper.query(sql, new MapHandler(),id);
	} 
	
	
	public List<Map<String,Object>> selectMapList(String id){
		String sql ="select username,password from t_user where id =?";
		return DbHelper.query(sql, new MapListHandler(),id);
	} 
	*/
	
	
}
