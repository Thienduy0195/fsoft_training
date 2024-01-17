package com.java.filter;

import com.java.model.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Member member = (Member) httpServletRequest.getSession().getAttribute("user");
        if (member == null && httpServletRequest.getRequestURI().contains("user")) {
           httpServletResponse.sendRedirect("/JSFWPA103/login");
           return;
        }
        System.out.println("DO FILTER");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
