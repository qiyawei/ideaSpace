package com.kaishengit.dao;

import com.kaishengit.entity.Major;

import java.util.List;

/**
 * Created by qiyawei on 2016/3/24.
 */
public interface MajorMapper {
    public Major findById(Integer id);
    public List<Major> findAll();
}
