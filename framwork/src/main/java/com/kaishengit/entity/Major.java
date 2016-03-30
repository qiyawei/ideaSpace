package com.kaishengit.entity;

import java.util.List;

/**
 * Created by qiyawei on 2016/3/24.
 */
public class Major {
    private Integer id;
    private String name;
    private List<Subject> list;
    public List<Subject> getList() {
        return list;
    }

    public void setList(List<Subject> list) {
        this.list = list;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
