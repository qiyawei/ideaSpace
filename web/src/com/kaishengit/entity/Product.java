package com.kaishengit.entity;

public class Product {
	private Integer id;
	private String productname;
	private Integer productnum;
	private Float productprice;
	private String productaddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getProductnum() {
		return productnum;
	}
	public void setProductnum(Integer productnum) {
		this.productnum = productnum;
	}
	
	public String getProductaddress() {
		return productaddress;
	}
	public void setProductaddress(String productaddress) {
		this.productaddress = productaddress;
	}
	public Float getProductprice() {
		return productprice;
	}
	public void setProductprice(Float productprice) {
		this.productprice = productprice;
	}
	
}
