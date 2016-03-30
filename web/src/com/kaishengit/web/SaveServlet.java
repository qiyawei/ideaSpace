package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by qiyawei on 2016/3/17.
 */
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = request.getParameter("productname");
        String price = request.getParameter("productprice");
        String num = request.getParameter("productnum");
        String address = request.getParameter("productaddress");

        Product pr = new Product();
        pr.setProductaddress(address);
        pr.setProductname(name);
        pr.setProductnum(Integer.valueOf(num));
        pr.setProductprice(Float.valueOf(price));
        ProductDao dao = new ProductDao();
        dao.save(pr);
        long lasttime = System.currentTimeMillis();
        session.setAttribute(name, new Long(lasttime));
        response.sendRedirect("/home.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/views/add.jsp").forward(request,response);
    }
}
