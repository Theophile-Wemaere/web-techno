package com.isep.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;

@WebServlet(name = "countCookie", value = "/count-cookie")
public class CountCookie extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        int count = 1;

        if (cookies != null || cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookiesCounter")) {
                    count = Integer.parseInt(cookie.getValue()) + 1;
                }
            }
        }
        Cookie counter = new Cookie("cookiesCounter", Integer.toString(count));
        response.addCookie(counter);

        String responseContent = "<head><link rel='stylesheet' href='CSS/styles.css' /></head>"
            + "<div class='centered'><h2>You visited this page exactly " + Integer.toString(count) + " times !</h2>" +
                "<a href='index.html'>Go back</a>"
                + "</div>";

        response.setContentType("text/html");
        response.getWriter().write(responseContent);
    }
}
