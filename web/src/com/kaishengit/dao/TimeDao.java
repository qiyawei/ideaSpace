package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Time;
import com.kaishengit.util.DbHelper;

public class TimeDao {
	public Time findById(Integer id){
		String sql ="select * from t_date where id=?";
		return DbHelper.query(sql, new BeanHandler<Time>(Time.class),id);
	}
	public void saveTime(Time t){
		String sql = "insert into t_date(time) values(?)";
		DbHelper.update(sql, t.getTime());
	}
}
