package com.kaishengit.test;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class Test6 {
    public static void main(String[] args) throws QiniuException {
        final String ak = "sGxR6n5CfLUZuMrpw1ilQm79pvIRqUZQ5h1gqSwF";
        final String sk = "yNIN4pNkMCd-MHAPHVqZ3LxcvlUuO-4-GM9ZQiit";
        final String buketName = "kaishengitdemo";
        Auth auth = Auth.create(ak,sk);
        String token = auth.uploadToken(buketName);
        UploadManager uploadManager = new UploadManager();
        Response response = uploadManager.put("d:/upload/1.jpg",null, token);
        //String str = response.bodyString();
        StringMap map = response.jsonToMap();
        System.out.println(map.get("key"));

    }
}
