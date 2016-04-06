package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class AdminDao {
    @Inject
    private JdbcTemplate jdbcTemplate;
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate1;

    public void save(Admin admin){
        String sql = "insert into admin(name,pwd) values(?,?)";
        jdbcTemplate.update(sql,admin.getName(),admin.getPwd());
    }
    public Admin findById(int id){
        String sql = "select * from admin where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                Admin admin = new Admin();
                admin.setPwd(resultSet.getString("pwd"));
                admin.setName(resultSet.getString("name"));
                return admin;
            }
        },id);
    }

    public List<Admin> findAll(){
        String sql = "select * from admin ";
        return jdbcTemplate.query(sql, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                Admin admin = new Admin();
                admin.setPwd(resultSet.getString("pwd"));
                admin.setName(resultSet.getString("name"));
                return admin;
            }
        });
    }

    public long count(){
        String sql = "select count(*) from admin";
        return jdbcTemplate.queryForObject(sql,Long.class);
    }

    public List<Admin> findByName(String name){
        String sql = "select * from admin where name =  ?";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<Admin>(Admin.class),name);
    }

    public void delete(int id){
        String sql = "delete from admin where id = :id";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",id);
        jdbcTemplate1.update(sql,map);
    }

    public void save1(Admin admin){
        String sql = "insert into admin(name,pwd) values(:name,:pwd)";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",admin.getName());
        map.put("pwd",admin.getPwd());
        jdbcTemplate1.update(sql,map);
    }
    public List<Admin> findAll1(){
        String sql = "select * from admin ";
        return  jdbcTemplate1.query(sql,new BeanPropertyRowMapper<Admin>(Admin.class));
    }

    public Admin findById1(int id){
        String sql = "select * from admin where id = :id";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",id);
        return jdbcTemplate1.queryForObject(sql,map,new BeanPropertyRowMapper<Admin>(Admin.class));

    }

















}
