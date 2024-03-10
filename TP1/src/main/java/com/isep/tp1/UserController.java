package com.isep.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;

@WebServlet(name = "userController", value = "/user-controller")
public class UserController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");

        int maxAge = 3600 * 24;
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        firstNameCookie.setMaxAge(maxAge);
        response.addCookie(firstNameCookie);

        Cookie lastNameCookie = new Cookie("lastName", lastName);
        lastNameCookie.setMaxAge(maxAge);
        response.addCookie(lastNameCookie);

        Cookie birthDateCookie = new Cookie("birthDate", birthDate);
        birthDateCookie.setMaxAge(maxAge);
        response.addCookie(birthDateCookie);

        Cookie sexCookie = new Cookie("sex", sex);
        sexCookie.setMaxAge(maxAge);
        response.addCookie(sexCookie);

        String responseContent =
                "<head><link rel='stylesheet' href='CSS/styles.css' /></head>" +
                "<div class='centered'><h2>Person Details</h2><table>" +
                        "<tr><td>First Name</td><td>" + firstName + "</td></tr>" +
                        "<tr><td>Last Name</td><td>" + lastName + "</td></tr>" +
                        "<tr><td>Birth Date</td><td>" + birthDate + "</td></tr>" +
                        "<tr><td>Sex</td><td>" + sex + "</td></tr>" +
                        "</table>"
                + "<a href='index.html'>Go back</a></div>";

        response.setContentType("text/html");
        response.getWriter().write(responseContent);
    }
}
