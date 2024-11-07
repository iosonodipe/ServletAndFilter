package com.example.demoservlet;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private ServletContext servletContext;

    public void init() {
        servletContext = getServletContext();

        servletContext.setAttribute("counter", 0);
        servletContext.setAttribute("message", "Hello World");

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        servletContext.setAttribute("counter", ((Integer)servletContext.getAttribute("counter"))+1);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + servletContext.getAttribute("message").toString() + "</h1>");
        out.println("<h3>" + "Servlet richiamato " + servletContext.getAttribute("counter").toString() + " volte" + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}