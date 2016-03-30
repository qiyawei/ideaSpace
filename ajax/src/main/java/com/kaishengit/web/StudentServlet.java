package com.kaishengit.web;

import com.google.gson.Gson;
import com.kaishengit.enty.Student;
import com.kaishengit.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/student.json")
public class StudentServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu  = new Student(1,"tom",85F);
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(2,"jim",75F));
        list.add(stu);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
