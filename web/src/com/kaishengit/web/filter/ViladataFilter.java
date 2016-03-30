package com.kaishengit.web.filter;

import com.kaishengit.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViladataFilter extends AbstractFilter {
    String staticPath;
    List<String> list = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         staticPath = filterConfig.getInitParameter("staticPath");
        String exceptStaticPath = filterConfig.getInitParameter("exceptStaticPath");
        String[] paths = exceptStaticPath.split(",");
        list = Arrays.asList(paths);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        if(url.startsWith(staticPath)){
            filterChain.doFilter(request,response);
        }else{
            if(list.contains(url)){
                filterChain.doFilter(request,response);
            }else{
                User user = (User) session.getAttribute("user");
                if(user != null){
                    filterChain.doFilter(request,response);
                }else{
                    response.sendRedirect("index.do?state=unlogin");
                }
            }

        }
    }
}
