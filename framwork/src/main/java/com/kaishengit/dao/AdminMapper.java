package com.kaishengit.dao;

import com.kaishengit.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    public Admin findById(int id);
    public void delete(int id);
    public void save(Admin admin);
    public void update(Admin admin);
    public List<Admin> findAll();
    public List<Admin> findAllByName(String name);
    public Admin findByNameAndPwd(Map<String,Object> map);
    public Admin findByNameAndPwd2(String name,String pwd);
    public Admin findByLikeName(String name);
}