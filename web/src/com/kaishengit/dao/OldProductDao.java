package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.OldProduct;
import com.kaishengit.entity.Product;
import com.kaishengit.util.DbHelper;

public class OldProductDao {
	/**
	 * 添加
	 */
	public void save(OldProduct product){
		String sql ="insert into t_oldproduct(productname,productprice,productnum,productaddress) values(?,?,?,?)";
		DbHelper.update(sql,product.getProductname(),product.getProductprice(),product.getProductnum(),product.getProductaddress());
	}
	/**
	 * 删除
	 */
	public void deleteById(Integer id){
		String sql = "delete from t_oldproduct where id=?";
		DbHelper.update(sql, id);
	}
	/**
	 * 修改产品
	 */
	public void update(OldProduct prod){
		String sql ="update t_oldproduct set productname=?,productprice=?,productnum=?,productaddress=? where id=?";
		DbHelper.update(sql, prod.getProductname(),prod.getProductprice(),prod.getProductnum(),prod.getProductaddress(),prod.getId());
	}
	
		
	/**
	 * 查询所有产品
	 */
	public List<OldProduct> findAll(){
		String sql ="select * from t_oldproduct";
		return DbHelper.query(sql, new BeanListHandler<OldProduct>(OldProduct.class));
	}
	/**
	 * 查询单个产品
	 */
	public OldProduct findById(Integer id){
		String sql ="select * from t_oldproduct where id=?";
		return DbHelper.query(sql, new BeanHandler<OldProduct>(OldProduct.class),id);
	}
	
	
	
	
}
