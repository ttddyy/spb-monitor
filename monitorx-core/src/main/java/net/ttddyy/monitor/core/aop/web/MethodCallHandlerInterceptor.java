package net.ttddyy.monitor.core.aop.web;

import net.ttddyy.monitor.core.aop.MethodCallContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final ServletRequestMethodCallContext context = new ServletRequestMethodCallContext();
        context.setMethod(request.getMethod());
        // TODO: add http related attribute to context
        MethodCallContextHolder.setContext(context);

        return true;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
