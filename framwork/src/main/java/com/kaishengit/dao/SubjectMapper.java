package com.kaishengit.dao;

import com.kaishengit.entity.Subject;

import java.util.List;
import java.util.Map;

/**
 * Created by qiyawei on 2016/3/24.
 */
public interface SubjectMapper {
    public List<Subject> findAll();
    public Subject findById(Integer id);
    public List<Subject> findByQuery(Map<String,Object> map);
    public List<Subject> findByQuery1(Map<String,Object> map);
    public void update(Subject subject);
}
