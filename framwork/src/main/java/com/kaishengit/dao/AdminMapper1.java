package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface AdminMapper1 {
    @Select("select * from admin where id = #{id}")
    public Admin findById(int id);

    @Delete("delete from admin where id = #{id}")
    public void delete(int id);

    @Insert("insert into admin(name,pwd) values(#{name},#{pwd})")
    public void save(Admin admin);

    @Update("update admin set name = #{name},pwd = #{pwd} where id = #{id}")
    public void update(Admin admin);

    @Select("select * from admin")
    public List<Admin> findAll();

    @Select("select * from where name = #{name}")
    public List<Admin> findAllByName(String name);

    @Select("select * from where name = #{name} and pwd = #{pwd}")
    public Admin findByNameAndPwd(Map<String, Object> map);

    @Select("select * from where name = #{name} and pwd = #{pwd}")
    public Admin findByNameAndPwd2(@Param("name")String name, @Param("pwd")String pwd);

    public Admin findByLikeName(String name);
}