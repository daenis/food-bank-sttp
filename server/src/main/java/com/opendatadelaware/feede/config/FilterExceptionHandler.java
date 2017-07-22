package com.opendatadelaware.feede.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterExceptionHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch(Throwable e) {
            FilterExceptionConsumer consumer = FilterExceptionConsumer.makeExceptionConsumer(e);
            httpServletResponse.setStatus(consumer.getStatusCode().value());
            httpServletResponse.getWriter().write(consumer.getJson());
        }
    }
}
