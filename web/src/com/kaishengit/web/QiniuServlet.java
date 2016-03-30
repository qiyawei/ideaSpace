package com.kaishengit.web;

import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QiniuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String ak = "sGxR6n5CfLUZuMrpw1ilQm79pvIRqUZQ5h1gqSwF";
        final String sk = "yNIN4pNkMCd-MHAPHVqZ3LxcvlUuO-4-GM9ZQiit";
        final String buketName = "kaishengitdemo";
        String key = request.getParameter("key");
        Auth auth = Auth.create(ak,sk);
        StringMap map = new StringMap();
        map.put("returnUrl","http://localhost/callback.do");
        String token = auth.uploadToken(buketName,null,3600,map);
        request.setAttribute("token",token);
        request.setAttribute("key",key);
        request.getRequestDispatcher("/WEB-INF/views/qiniu.jsp").forward(request,response);

    }
}
