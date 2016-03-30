package com.kaishengit.service;


import com.kaishengit.enty.Student;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> findAll(){
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("tom");
        s1.setScore(52.0F);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("rose");
        s2.setScore(68.0F);

        Student s3 = new Student();
        s3.setId(3);
        s3.setName("jim");
        s3.setScore(82.0F);

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        return list;

    }
}
