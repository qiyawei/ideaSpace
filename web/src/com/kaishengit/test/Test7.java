package com.kaishengit.test;

import com.kaishengit.entity.Page;
import org.apache.poi.hssf.record.formula.functions.T;

public class Test7 {
    public static void main(String[] args) {
        Page page = new Page("3",20,4);
        Page page1 = new Page();
        System.out.println(page1.getTotalCount());
        System.out.println(page.getTotalCount());
    }
}
