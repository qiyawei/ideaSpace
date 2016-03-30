package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsonp.do")
public class JsonpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello,JSONP");

        String methodName = req.getParameter("cb");

        PrintWriter out = resp.getWriter();
        out.print(methodName + "({\"name\":\"tom\",\"age\":23})");
        out.flush();
        out.close();

    }
}
