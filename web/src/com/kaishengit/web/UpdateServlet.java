package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qiyawei on 2016/3/17.
 */
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("prodname");
        String price = request.getParameter("prodprice");
        String num = request.getParameter("prodnum");
        String address = request.getParameter("prodaddress");

        Product prod = new Product();
        prod.setId(Integer.valueOf(id));
        prod.setProductaddress(address);
        prod.setProductnum(Integer.valueOf(num));
        prod.setProductname(name);
        prod.setProductprice(Float.valueOf(price));

        ProductDao dao = new ProductDao();
        dao.update(prod);
        response.sendRedirect("/home.do");
    }

}
