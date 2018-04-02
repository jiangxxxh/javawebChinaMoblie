package com.chinamobile.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharFilter implements Filter {

    private FilterConfig filterConfig;// 过滤器配置对象
    private String encoding;// 字符编码


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = this.filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getCharacterEncoding() == null){
            servletRequest.setCharacterEncoding(encoding);
        }
        // 继续执行过滤器后面的操作
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
