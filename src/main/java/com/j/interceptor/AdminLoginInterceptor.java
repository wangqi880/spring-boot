package com.j.interceptor;

import com.j.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
       User user = (User) session.getAttribute("loginUser");
       user = new User();
       user.setUsername("wq");
        session.setAttribute("loginUser",user);
        if(null==user){
            String s = request.getContextPath();
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
       return super.preHandle(request,response,handler);
    }
}
