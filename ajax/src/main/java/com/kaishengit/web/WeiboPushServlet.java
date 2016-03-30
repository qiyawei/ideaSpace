package com.kaishengit.web;

import com.google.gson.Gson;
import com.kaishengit.enty.Weibo;
import com.kaishengit.service.WeiboService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/weibopush.do")
public class WeiboPushServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start = req.getParameter("start");

        WeiboService service = new WeiboService();
        List<Weibo> weiboList = service.findByMaxId(Integer.valueOf(start));

        String json = new Gson().toJson(weiboList);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();

    }
}
