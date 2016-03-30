package com.kaishengit.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File("d:/upload");
        if(!file.exists()){
            file.mkdir();
        }
        //设置临时文件夹
        File tempdir = new File("d:/temp");
        if(!tempdir.exists()){
            tempdir.mkdir();
        }
        if(ServletFileUpload.isMultipartContent(request)){
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //设置缓冲区大小
            fileItemFactory.setSizeThreshold(1024*1024);
            //设置临时文件夹
            fileItemFactory.setRepository(tempdir);

            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            //设置文件上传体积
            fileUpload.setFileSizeMax(1024*1024*10);
            String name = null;
            String cardnum = null;
            try {
                List<FileItem> fileItemList = fileUpload.parseRequest(request);
                for(FileItem fileItem : fileItemList){
                    if(fileItem.isFormField()){
                        if("name".equals(fileItem.getFieldName())){
                             name = fileItem.getString("UTF-8");
                        }else if("cardnum".equals(fileItem.getFieldName())){
                             cardnum = fileItem.getString();
                        }
                    }else {
                        String fileName = fileItem.getName();
                        long fileLength = fileItem.getSize();
                        System.out.println(fileName + " : " + fileLength);
                        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                        InputStream inputStream = fileItem.getInputStream();
                        FileOutputStream outputStream = new FileOutputStream(new File("d:/upload", fileName));
                        IOUtils.copy(inputStream, outputStream);
                        outputStream.flush();
                        outputStream.close();
                        inputStream.close();
                    }
                }
                System.out.println("name : " + name +" cardnum: " + cardnum );
            } catch (FileUploadException e) {
                e.printStackTrace();
                throw  new RuntimeException("文件上传异常");
            }


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(request,response);
    }
}
