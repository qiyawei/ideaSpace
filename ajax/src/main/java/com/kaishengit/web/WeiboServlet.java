package com.kaishengit.web;

import com.kaishengit.enty.Weibo;
import com.kaishengit.service.WeiboService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/weibo.do")
public class WeiboServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeiboService service = new WeiboService();
        List<Weibo> weiboList = service.findAll();

        req.setAttribute("weiboList",weiboList);
        req.setAttribute("maxId",weiboList.get(0).getId());
        req.getRequestDispatcher("weibo.jsp").forward(req,resp);
    }
}
