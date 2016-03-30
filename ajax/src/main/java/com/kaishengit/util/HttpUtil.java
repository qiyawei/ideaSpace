package com.kaishengit.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {
    public static String sendHttpGetRequest(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String result = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);

            int httpcode = response.getStatusLine().getStatusCode();
            if(httpcode == 200){
                InputStream in = response.getEntity().getContent();
                result = IOUtils.toString(in);
            }

            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;

    }

}
