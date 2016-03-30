package com.kaishengit;

import com.google.gson.Gson;
import com.kaishengit.enty.Student;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Student stu  = new Student(1,"tom",85F);
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(2,"jim",75F));
        list.add(stu);
        Gson gson = new Gson();
       String json = gson.toJson(list);
        System.out.println(json);
    }
}
