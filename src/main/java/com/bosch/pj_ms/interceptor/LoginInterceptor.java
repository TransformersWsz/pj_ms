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
        boolean isIntercepted = true;    // 是否拦截
        HttpSession session = request.getSession();
        Object adminInfo = session.getAttribute("adminInfo");
        if ("/login.html".equals(request.getRequestURI()) || "/session".equals(request.getRequestURI())) {
            System.out.println("正常页面");
            return true;
        }
        else {

            System.out.println(session.getId());

            if (adminInfo == null) {
                System.out.println("用户未登陆！！！");
                response.sendRedirect("/login.html");
                return false;
            }
            else {
                System.out.println("用户已经登陆。。。");
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception { }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception { }
}
