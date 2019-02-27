package com.redapplenet.cloud.utils.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:58
 * @Version
 **/
@WebFilter(filterName = "traceFilter", urlPatterns = "/*")
public class TraceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter..........................");
        String traceId = LocalDateTime.now().toString().replace("T","").replace(":","").replace("-","").replace(".","");

        TraceUtil.saveTraceId(traceId);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
