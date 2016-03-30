package com.kaishengit.test;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by qiyawei on 2016/3/18.
 */
public class TestMd5 {
    public static void main(String[] args) {
        String str = "";
       String str1 =  DigestUtils.md5Hex(str);
        System.out.println(str1);
    }
}
