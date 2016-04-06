package com.kaishengit.web;


import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import sun.security.krb5.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send.do")
public class EditServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Auth auth = Auth.create("","");

        StringMap map = new StringMap();

        map.put("returnBody","{\"success\":true,\"file_path\":\"http://7xjf7a.com1.z0.glb.clouddn.com/$(key)-pic\"}");

        String token = auth.uploadToken("",null,3600,map);

        req.setAttribute("token",token);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);

    }
}
