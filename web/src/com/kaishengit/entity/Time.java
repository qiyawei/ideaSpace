package com.kaishengit.entity;

import java.io.Serializable;

public class Time implements Serializable{
	private Integer id;
	private String time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
