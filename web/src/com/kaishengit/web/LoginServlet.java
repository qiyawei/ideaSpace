package com.kaishengit.web;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import com.kaishengit.util.CodeUtil;
import com.kaishengit.util.EmailUtil;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(456);
        resp.sendRedirect("/index.do?state=unlogin");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        String code = request.getParameter("code");
        //CodeUtil codeUtil = new CodeUtil();
        int num = CodeUtil.get("code");
        //System.out.println(num);
       if(num >= 3) {
            String sessionCode = (String) session.getAttribute("code");
            if (!sessionCode.equals(code)) {
                response.sendRedirect("/index.do?state=code&num=" + num);
                return;
            }
        }

        UserDao dao = new UserDao();
       final User user = dao.findByUsername(name);
        if(user != null && user.getPassword().equals(pwd)){
           /* Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                EmailUtil.sendSimpleEmail("主题","欢迎你" + user.getUsername() + "登陆了",user.getEmail());


                }
            });
            thread.start();*/
           if("yes".equals(rememberme)){
                Cookie cookie = new Cookie("username",name);
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                cookie.setHttpOnly(true);

                Cookie cookie1 = new Cookie("password",pwd);
                cookie1.setMaxAge(60*60*24);
                cookie1.setPath("/");
                cookie1.setHttpOnly(true);

                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            session.setAttribute("user", user);
            response.sendRedirect("/home.do");
        }else{
            num++;
            CodeUtil.put("code",num);
            response.sendRedirect("/index.do?state=error&num=" + num);
            }

        }


}
