package com.kaishengit.web;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyawei on 2016/3/25.
 */
public class CallbackServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String upload_ret = request.getParameter("upload_ret");
        upload_ret = new String(Base64.decodeBase64(upload_ret));
        Gson gson = new Gson();
        Map<String,Object> map = gson.fromJson(upload_ret,HashMap.class);

        String key = (String) map.get("key");
        response.sendRedirect("/qiniu.do?key="+key);

    }
}
