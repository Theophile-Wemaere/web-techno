package com.isep.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;

@WebServlet(name = "readCookie", value = "/read-cookie")
public class ReadCookie extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.getWriter().write("No cookies found!");
            return;
        }

        String responseContent = "<head><link rel='stylesheet' href='CSS/styles.css' /></head>"
                + "<div class='centered'><table>"
                + "<tr><th>Name</th><th>Value</th><th>Max Age</th></tr>";
        for (Cookie cookie : cookies) {
            responseContent += String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", cookie.getName(), cookie.getValue(), cookie.getMaxAge());
        }

        responseContent += "</table>" +
                "<a href='index.html'>Go back</a>"
                + "</div>";

        response.setContentType("text/html");
        response.getWriter().write(responseContent);
    }
}
