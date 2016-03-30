package com.kaishengit.dao;

import com.kaishengit.entity.Subject;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SubjectMapper2 {
    final String sql ="select sub.id,sub.name,sub.classhour,sub.majorid,maj.id as typeid,maj.name as typename" +
            "  from subject as sub inner join major as maj on sub.majorid=maj.id\n" +
            "  where sub.id=#{id}";

    //@Select(sql )

    @Select("select * from subject")
    @Results(value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "classhour",column = "classhour"),
            @Result(property = "majorid",column = "majorid"),
            @Result(property = "major",column = "majorid",one =
            @One(select = "com.kaishengit.dao.MajorMapper2.findById"))
    })
    public List<Subject> findAll();
    //public Subject findById(Integer id);

}
