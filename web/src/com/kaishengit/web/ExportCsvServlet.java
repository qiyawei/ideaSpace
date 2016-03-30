package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by qiyawei on 2016/3/24.
 */
public class ExportCsvServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=GBK");
        response.addHeader("Content-Disposition", "attachment;filename=\"data.csv\"");
        PrintWriter writer = response.getWriter();
        writer.println("产品名称,价格,数量,产地");
        List<Product> list = new ProductDao().findAll();
        for(Product product : list){
            writer.println(product.getProductname() + "," + product.getProductprice() + "," + product.getProductnum() + "," + product.getProductaddress());
        }
        writer.flush();
        writer.close();
    }
}
