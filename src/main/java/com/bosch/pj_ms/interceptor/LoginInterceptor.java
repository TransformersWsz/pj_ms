package com.bosch.pj_ms.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isIntercepted = true;    // 是否放行
        HttpSession session = request.getSession();
        Object adminInfo = session.getAttribute("username");
        if ("/login.html".equals(request.getRequestURI()) || "/session".equals(request.getRequestURI())) {
            if (adminInfo != null)     // 用户已经登录
                response.sendRedirect("/index.html");
        }
        else {
            if (adminInfo == null) {
                System.out.println("LoginInterceptor: 用户未登陆！！！");
                response.sendRedirect("/login.html");
                isIntercepted = false;
            }
        }
        return isIntercepted;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception { }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception { }
}
