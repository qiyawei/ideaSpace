package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qiyawei on 2016/3/17.
 */
public class DelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductDao dao = new ProductDao();
        dao.deleteById(Integer.valueOf(id));
        response.sendRedirect("/home.do");
    }
}
