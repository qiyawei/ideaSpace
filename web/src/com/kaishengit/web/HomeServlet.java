package com.kaishengit.web;

import com.kaishengit.dao.OldProductDao;
import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.OldProduct;
import com.kaishengit.entity.Page;
import com.kaishengit.entity.Product;
import com.kaishengit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by qiyawei on 2016/3/17.
 */
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();
        String p = request.getParameter("p");
        ProductDao dao = new ProductDao();
        OldProductDao oldDao = new OldProductDao();
        Page<Product> page = service.findByPage(p);
        HttpSession session  = request.getSession();

        long now = System.currentTimeMillis();
        for(Product prod : page.getList()){
            String name = prod.getProductname();
            Long oldTime = (Long)session.getAttribute(name);
            if(oldTime != null){
                long time = oldTime.longValue();

                if((now - time) > 10000){
                    //list.remove(prod);
                    dao.deleteById(prod.getId());
                    OldProduct oldProd = new OldProduct();
                    oldProd.setProductname(prod.getProductname());
                    oldProd.setProductaddress(prod.getProductaddress());
                    oldProd.setProductprice(prod.getProductprice());
                    oldProd.setProductnum(prod.getProductnum());
                    oldDao.save(oldProd);
                }
            }

            //System.out.println(oldTime);


        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request,response);
    }
}
