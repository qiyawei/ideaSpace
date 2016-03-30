package com.kaishengit.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by qiyawei on 2016/3/26.
 */
public class ExportSqlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        response.setContentType("text/plain;charset=GBK");
        String fileName = new Date().getTime() +"db.sql";
        response.addHeader("Content-Disposition","attachment;fileName=\""+fileName+"\"");
        Runtime runtime = Runtime.getRuntime();
        String cmd = "mysqldump -uroot -p123123 --default-character-set=gbk mydb";
        Process process = runtime.exec(cmd);
        InputStream inputStream = process.getInputStream();
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
