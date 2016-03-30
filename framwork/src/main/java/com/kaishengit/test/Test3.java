package com.kaishengit.test;

import com.kaishengit.dao.AdminMapper;
import com.kaishengit.entity.Admin;
import com.kaishengit.util.SqlSessinUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessinUtil.getSqlSession(true);
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
      /*  Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","tom");
        map.put("pwd","11111");*/
        //Admin admin = adminMapper.findByNameAndPwd2("tom","11111");
        Admin admin = adminMapper.findByLikeName("o");
        System.out.println(admin.getId());
       /* List<Admin> list  = adminMapper.findAllByName("tom");
        for(Admin admin :list){
            System.out.println(admin.getName());
        }*/
        
      /*  List<Admin> list = adminMapper.findAll();
        for(Admin admin :list){
            System.out.println(admin.getName());
        }*/
       /* AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.findById(2);
        System.out.println(admin.getName());
        admin.setPwd("11111");
        adminMapper.update(admin);*/
    }

}
