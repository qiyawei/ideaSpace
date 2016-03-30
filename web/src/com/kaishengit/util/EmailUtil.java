package com.kaishengit.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;
import java.util.Properties;

public class EmailUtil {
    private static String host;
    private static String port;
    private static String username;
    private static String password;
    private static String from;
    private static String encode;

    static{
        Properties prop = new Properties();
        try {
            prop.load(EmailUtil.class.getClassLoader().getResourceAsStream("email.properties"));
            host = prop.getProperty("email.host");
            port = prop.getProperty("email.port");
            username = prop.getProperty("email,username");
            password = prop.getProperty("email.password");
            from = prop.getProperty("email.from");
            encode = prop.getProperty("email.encode");

        } catch (IOException e) {
            e.printStackTrace();
           throw new RuntimeException("发邮件异常",e);
        }
    }

    public static void sendSimpleEmail(String subject,String msg,String address){
        SimpleEmail email = new SimpleEmail();
        email.setHostName(host);
        email.setAuthentication(username,password);
        email.setSslSmtpPort(port);
        email.setTLS(true);
        email.setCharset(encode);

        try {
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(address);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }




}
