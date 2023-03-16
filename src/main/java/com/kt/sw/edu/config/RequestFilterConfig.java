package com.kt.sw.edu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

//@WebFilter  <-- workshop 중간에 실습 할꺼예요
public class RequestFilterConfig implements Filter {

    private final static Logger log = LoggerFactory.getLogger(RequestFilterConfig.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Map<String, String> headers = Collections.list(httpRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, httpRequest::getHeader));
        log.info(headers.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
