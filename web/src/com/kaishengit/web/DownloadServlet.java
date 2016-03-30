package com.kaishengit.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("file");
        String open = request.getParameter("open");

        if(fileName == null||"".equals(fileName)){
            response.sendError(404);
        }else{
            File file = new File("d:/upload",fileName);
            if(!file.exists()){
                response.sendError(404);
            }else{
                response.setContentType("application/octet-stream");
                if("true".equals(open)){
                    response.addHeader("Content-Disposition","attachment;fileName=\""+fileName+"\"");

                    response.setContentLength(new Long(file.length()).intValue());
                }
                FileInputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream,outputStream);
            }
        }
    }
}
