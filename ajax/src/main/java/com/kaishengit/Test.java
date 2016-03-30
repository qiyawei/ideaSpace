package com.kaishengit;
import com.squareup.okhttp.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.apache.org").build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);

//        RequestBody body =
//                RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
//                        "{name:\"tom\",password:\"123123\"}");
       // Request request = new Request.Builder().url("http://www.apache.org")
//                .post(body).build();
//
//        Response response = client.newCall(request).execute();
//        String result = response.body().string();
//
//        System.out.println(result);




//        CloseableHttpClient  httpClient = HttpClients.createDefault();
//        HttpPost post = new HttpPost("http://192.168.0.147:8080/login.do");
//        List<NameValuePair> list = new ArrayList<NameValuePair>();
//        list.add(new BasicNameValuePair("name","tom"));
//        list.add(new BasicNameValuePair("pwd","123456"));
//        post.setEntity(new UrlEncodedFormEntity(list));
//        HttpResponse response = httpClient.execute(post);

//        HttpGet httpGet = new HttpGet("http://www.pingwest.com/feed/");
//        HttpResponse response = httpClient.execute(httpGet);
//        int code = response.getStatusLine().getStatusCode();
//        if(code == 200){
//            InputStream in = response.getEntity().getContent();
//            String result = IOUtils.toString(in);
//            System.out.println(result);
//        }else{
//            System.out.println("请求异常" + code);
//        }
//        httpClient.close();

    }
}
