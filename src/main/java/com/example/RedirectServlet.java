package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet {

    @WebServlet("/redirect/internal")
    public static class InternalRedirectServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.sendRedirect("/hello.html");
        }
    }

    @WebServlet("/redirect/internal-a")
    public static class InternalAbsolutePathRedirectServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String location = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + "hello.html";
            resp.sendRedirect(location);
        }

    }

    @WebServlet("/redirect/external")
    public static class ExternalRedirectServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.sendRedirect("https://www.google.com");
        }
    }
}
