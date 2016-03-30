package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Product;
import com.kaishengit.util.DbHelper;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ProductDao {
	/**
	 * ���
	 */
	public void save(Product product){
		String sql ="insert into t_product(productname,productprice,productnum,productaddress) values(?,?,?,?)";
		DbHelper.update(sql,product.getProductname(),product.getProductprice(),product.getProductnum(),product.getProductaddress());
	}
	/**
	 * ɾ��
	 */
	public void deleteById(Integer id){
		String sql = "delete from t_product where id=?";
		DbHelper.update(sql, id);
	}
	/**
	 * �޸Ĳ�Ʒ
	 */
	public void update(Product prod){
		String sql ="update t_product set productname=?,productprice=?,productnum=?,productaddress=? where id=?";
		DbHelper.update(sql, prod.getProductname(),prod.getProductprice(),prod.getProductnum(),prod.getProductaddress(),prod.getId());
	}


	/**
	 * ��ѯ���в�Ʒ
	 */
	public List<Product> findAll(){
		String sql ="select * from t_product";
		return DbHelper.query(sql, new BeanListHandler<Product>(Product.class));
	}
	/**
	 * ��ѯ������Ʒ
	 */
	public Product findById(Integer id){
		String sql ="select * from t_product where id=?";
		return DbHelper.query(sql, new BeanHandler<Product>(Product.class),id);
	}


	public int count() {
		String sql = "select count(*) from t_product";
		return DbHelper.query(sql,new ScalarHandler<Long>()).intValue();
	}
	public List<Product> findByPage(int startNo, int pageSize) {
		String sql = "select * from t_product limit ?,?";
		return DbHelper.query(sql,new BeanListHandler<Product>(Product.class), startNo,pageSize);
	}

}
