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
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null && id.matches("\\d+")){
            ProductDao dao = new ProductDao();
            Product prod = dao.findById(Integer.valueOf(id));

            if(prod != null){
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("/WEB-INF/views/show.jsp").forward(request, response);
            }else{
                response.sendError(404,"请求的资源不存在");
            }
        }else{
            response.sendError(404,"请求的资源不存在");
        }

    }
}
