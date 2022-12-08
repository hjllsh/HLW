package com.hlw.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class MyInterceptor implements HandlerInterceptor {
//    原始方法调用前执行的内容
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        response.setContentType("text/html;charset=utf-8");
        if (userId == null) {
            String uri = request.getRequestURI();
            System.out.println(request.getContextPath());
            System.out.println("===============");
            System.out.println(uri);
            System.out.println("===============");
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/pages/login.html");
//            response.sendRedirect(request.getContextPath()+"www.baidu.com");
            return false;
        } else {
            return true;
        }
    }

    //原始方法调用后执行的内容
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
//    原始方法调用完成后执行的内容
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
