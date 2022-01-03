package com.fclass.bootapp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
@Slf4j
public class CustomFirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("+++++++++++++++++ initializing the first custom filter ++++++++++++++++++++++++++");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("in the first custom filter -> {} : {}", request.getMethod(), request.getRequestURI());
        filterChain.doFilter(request, response);

    }


    @Override
    public void destroy() {
        log.info("+++++++++++++++++ destroying the first custom filter ++++++++++++++++++++++++++");
    }
}
