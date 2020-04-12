package com.ujiuye.format;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-09 17:03
 **/

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURL = req.getRequestURI();
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null || requestURL.contains("static") || requestURL.contains("login")||requestURL.contains("code")||requestURL.contains("skin")
                ||requestURL.contains("upload")||requestURL.contains("images")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
