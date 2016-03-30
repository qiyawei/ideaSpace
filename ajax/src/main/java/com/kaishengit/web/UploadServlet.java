package com.kaishengit.web;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet("/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("img");
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream(new File("C:/", UUID.randomUUID().toString() + ".jpg"));

        IOUtils.copy(in, out);

        out.flush();
        out.close();
        in.close();


    }
}
