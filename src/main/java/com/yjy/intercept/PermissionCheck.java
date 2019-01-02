package com.yjy.intercept;


import com.yjy.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionCheck implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        User loginUser = (User) request.getSession().getAttribute("loginUser");

        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {

            //如果是发表评论ajax则放行
            if (uri.matches("/comment/\\d*/spoken")) {
                return true;
            }else {
                if (loginUser == null) {
                    response.getWriter().println("你没有权限");
                    return false;
                }
            }
            //否则进入是否登录判断
        }else {
            if (loginUser == null) {
                response.sendRedirect(request.getContextPath()+"/login?redirect="+uri);
                return false;
            }
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
