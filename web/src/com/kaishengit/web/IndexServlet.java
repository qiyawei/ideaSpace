package com.kaishengit.web;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class IndexServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("username".equals(cookie.getName())){
                username = cookie.getValue();
            }else if("password".equals(cookie.getName())){
                password = cookie.getValue();
            }
        }

       // User user = new UserDao().findByUsername(username);
        if(username != null && password != null){
            User user = new UserDao().findByUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/home.do");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
    }
}
