package com.show.admin.scetc.filter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止xss攻击与sql注入
 * @author 徐塬峰 2019/4/11
 **/
@Component
@WebFilter(urlPatterns = "/*", filterName = "myfilter")
public class XssAndSqlFilter  implements Filter {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          // no do something ...
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

//        logger.info("--------------xss过滤---------------------");
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
    }
    @Override
    public void destroy() {
          // no do something
    }
}
