package com.kaishengit.dao;

import com.kaishengit.entity.Major;
import org.apache.ibatis.annotations.Select;

/**
 * Created by qiyawei on 2016/3/24.
 */
public interface MajorMapper2 {
    @Select("select * from major where id = #{id}")
    public Major findById(Integer id);
}
