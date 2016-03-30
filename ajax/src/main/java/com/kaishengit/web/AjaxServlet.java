package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax.do")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String name = request.getParameter("username");
        //name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        //System.out.println(name);
        //添加响应头让浏览器不进行缓存
        response.addHeader("pragma","no-cache");
        response.addHeader("cache-control","no-cache");
        response.addHeader("expires","0");
        System.out.println("hello.ajax");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        PrintWriter writer = resp.getWriter();
        if("tom".equals(name)){
            writer.print("yes");
        }else {
            writer.print("no");
        }
        writer.flush();
        writer.close();
    }
}
