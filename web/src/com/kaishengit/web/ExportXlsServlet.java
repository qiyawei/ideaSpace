package com.kaishengit.web;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by qiyawei on 2016/3/24.
 */
public class ExportXlsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(456456);
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("产品表");
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("产品名称");
        titleRow.createCell(1).setCellValue("价格");
        titleRow.createCell(2).setCellValue("数量");
        titleRow.createCell(3).setCellValue("产地");
        List<Product> list = new ProductDao().findAll();
        for(int i = 0;i < list.size();i++){
            Row contentRow = sheet.createRow(i+1);
            Product product = list.get(i);
            contentRow.createCell(0).setCellValue(product.getProductname());
            contentRow.createCell(1).setCellValue(product.getProductprice());
            contentRow.createCell(2).setCellValue(product.getProductnum());
            contentRow.createCell(3).setCellValue(product.getProductaddress());
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename=\"data.xls\"");
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
}
