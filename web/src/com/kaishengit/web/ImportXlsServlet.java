package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by qiyawei on 2016/3/24.
 */
public class ImportXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/importxls.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            ProductDao dao = new ProductDao();

            try {
                List<FileItem> fileItemList = fileUpload.parseRequest(request);
                for(FileItem fileItem : fileItemList){
                    if(!fileItem.isFormField()){

                        InputStream inputStream = fileItem.getInputStream();
                        Workbook workbook = new HSSFWorkbook(inputStream);
                        Sheet sheet = workbook.getSheetAt(0);
                        int rownum = sheet.getLastRowNum();
                       // System.out.println(rownum);
                        for(int i = 0;i <= rownum;i++){
                            Row row = sheet.getRow(i);
                            Product product = new Product();
                            int cellnum =  row.getLastCellNum();
                            for(int j = 0;j < cellnum;j++){
                                Cell cell = row.getCell(j);
                                if(j == 0){
                                    String value = cell.getStringCellValue();
                                    product.setProductname(value);
                                }else if(j == 1){
                                    double num = cell.getNumericCellValue();
                                    product.setProductprice(new Double(num).floatValue());
                                }else if(j == 2){
                                    double num = cell.getNumericCellValue();
                                    product.setProductnum(new Double(num).intValue());
                                }else if(j == 3){
                                    String value = cell.getStringCellValue();
                                    product.setProductaddress(value);
                                }
                                //ProductDao
                               /* Cell cell = row.getCell(i);
                                if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                                    String value = cell.getStringCellValue();
                                }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                                    double num = cell.getNumericCellValue();
                                }*/
                            }
                            dao.save(product);
                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
                throw  new RuntimeException("文件上传异常");
            }


        }
        response.sendRedirect("/home.do");

    }
}
