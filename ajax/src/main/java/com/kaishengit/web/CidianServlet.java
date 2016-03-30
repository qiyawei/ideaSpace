package com.kaishengit.web;

import com.kaishengit.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cidian.do")
public class CidianServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("q");
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q=" + word;

        String xml = HttpUtil.sendHttpGetRequest(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(xml);
        out.flush();
        out.close();
    }
}
