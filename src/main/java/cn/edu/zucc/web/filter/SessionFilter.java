package cn.edu.zucc.web.filter;

import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器 判断用户是否已登录
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since 2016-07-07
 */
public class SessionFilter extends OncePerRequestFilter {

    /**
     * 账号拦截器
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String notFilter = "/login";
        String uri = request.getRequestURI();
        if (uri.contains("page")|| uri.contains("user")||uri.contains("admin")){
            boolean doFilter = true;
            if (uri.contains(notFilter))
                doFilter = false;
            if(doFilter){
                Object obj = request.getSession().getAttribute("userInfo");
                if(null == obj){
                    response.sendRedirect("ntr/page/login");
                }else{
                    filterChain.doFilter(request,response);
                }
            }else{
                filterChain.doFilter(request,response);
            }
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
