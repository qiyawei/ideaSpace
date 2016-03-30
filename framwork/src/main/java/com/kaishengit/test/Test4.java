package com.kaishengit.test;

import com.kaishengit.dao.*;
import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Major;
import com.kaishengit.entity.Subject;
import com.kaishengit.util.SqlSessinUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {

        SqlSession sqlSession = SqlSessinUtil.getSqlSession(true);
        SubjectMapper2 subjectMapper = sqlSession.getMapper(SubjectMapper2.class);
        List<Subject> list = subjectMapper.findAll();
        for(Subject subject : list){
            System.out.println(subject.getName()+":"+subject.getMajor().getName());
        }
       /*MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
        Major m  = majorMapper.findById(1);
        System.out.println(m.getList().size());*/
     /*  List<Major> list =  majorMapper.findAll();
        for(Major major : list){
            System.out.println(major.getList().size());
        }*/
       /* SubjectMapper subjectMapper =  sqlSession.getMapper(SubjectMapper.class);
        List<Subject> subjectList = subjectMapper.findAll();
        for(Subject s : subjectList){
            System.out.println(s.getName() + ":"+ s.getMajor().getName());
        }*/
       /* AdminMapper1 adminMapper = sqlSession.getMapper(AdminMapper1.class);
        Admin admin = adminMapper.findById(1);
        System.out.println(admin.getName());*/
/*
        sqlSession.close();

        SqlSession sqlSession1 = SqlSessinUtil.getSqlSession(true);
        AdminMapper adminMapper1 = sqlSession1.getMapper(AdminMapper.class);
        Admin admin2 = adminMapper1.findById(1);
       sqlSession1.close();
        System.out.println(admin2.getName());
*/



        //SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
        /*Map<String,Object> map = new HashMap<String, Object>();
        Subject sub1 = new Subject();
        //sub1.setClasshour(150);
        sub1.setName("sss");
        sub1.setId(7);*/

       // subjectMapper.update(sub1);
       // map.put("majorid",1);
       /* map.put("classhour",80);
        List<Subject> list = subjectMapper.findByQuery1(map);
        for(Subject subject : list){
            System.out.println(subject.getName());
        }*/
        /*AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
        Major major = majorMapper.findById(1);
        List<Subject> list = major.getList();
        for(Subject subject : list){
            System.out.println(subject.getName());
        }
*/
       /* SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
        Subject subject = subjectMapper.findById(10);
        System.out.println(subject.getMajor().getName());*/
        //System.out.println(subject.getMajor().getName());
        /*Admin admin = new Admin();
        admin.setPwd("77777");
        admin.setName("jim");
        adminMapper.save(admin);
        System.out.println(admin.getId());*/
    }
}
