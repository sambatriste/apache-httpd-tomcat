package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("")
public class Hello extends HttpServlet {

    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String envAppName = System.getenv("APP_NAME");
        String appName = envAppName == null ? "Nameless" : envAppName;
        req.setAttribute("appName", appName);

        int cnt = counter.incrementAndGet();
        req.setAttribute("cnt", cnt);

        req.getRequestDispatcher("/WEB-INF/view/hello.jsp")
           .forward(req, resp);
    }
}
