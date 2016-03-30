package com.kaishengit.service;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Page;
import com.kaishengit.entity.Product;

import java.util.List;

public class ProductService {

    public Page<Product> findByPage(String p) {
        ProductDao dao = new ProductDao();
        int count = dao.count();
        Page<Product> page = new Page<Product>(p,count,5);
        List<Product> productList = dao.findByPage(page.getStartNo(),page.getPageSize());
        page.setList(productList);
        return page;
    }
}
