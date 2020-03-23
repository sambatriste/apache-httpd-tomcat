package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/cookie")
public class CookieTester extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("foo", "bar");
        resp.addCookie(cookie);
        resp.setStatus(200);
        resp.setHeader("content-type", "text/plain");
        try (OutputStream o = resp.getOutputStream()) {
            o.write("hello".getBytes());
        }
    }
}
