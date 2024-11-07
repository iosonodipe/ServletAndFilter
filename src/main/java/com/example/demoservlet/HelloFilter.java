package com.example.demoservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello-servlet")
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtro...");
        ServletContext servletContext = servletRequest.getServletContext();

        if ( (Integer) servletContext.getAttribute("counter") != 0){
        if ( (Integer) servletContext.getAttribute("counter") %2 == 0) servletContext.setAttribute("message", "Counter dispari");
        else servletContext.setAttribute("message", "Counter pari");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
