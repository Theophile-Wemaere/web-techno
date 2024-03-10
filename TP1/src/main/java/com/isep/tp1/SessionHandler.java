package com.isep.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "sessionHandler", value = "/session-handler")
public class SessionHandler extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if(action != null) {
            switch(action){
                case "logout":
                    session.invalidate();
                    response.sendRedirect("index.html");
                    return;
                case "identify":
                    String birthdate = request.getParameter("birthDate");
                    String fullName = request.getParameter("name");
                    session.setAttribute("birthDate", birthdate);
                    session.setAttribute("fullName", fullName);
                    break;
            }
        }


        boolean visitedBefore = session.getAttribute("visitedBefore") != null;
        String message;
        if (visitedBefore) {
            message = "Welcome back!";
        } else {
            message = "Welcome on my site!";
            session.setAttribute("visitedBefore", true);
        }

        String responseContent = "<head><link rel='stylesheet' href='CSS/styles.css' /></head>"
                + "<div class='centered'><h1>" + message+ "</h1>";

        String birthdate = String.valueOf(session.getAttribute("birthDate"));
        String fullName = String.valueOf(session.getAttribute("fullName"));
        if(birthdate.equals("null") || fullName.equals("null")) { // ask for birthdate and name
            responseContent += "<form action='session-handler?action=birthdate' method='get'>"
            + "<label for='name'>Full Name:</label>"
            + "<input type='text' name='name' id='name' required>"
            + "<label for='birthDate'>Birth Date (MM/DD/YYYY):</label>"
            + "<input type='date' name='birthDate' id='birthDate' required>"
            + "<input name='action' value='identify' style='display: none;'>"
            +"<input type='submit' style='margin-top: 20px;' value='Submit'>";
        } else { // display number of days before birthday
            LocalDate birthDateObj = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate today = LocalDate.now();
            LocalDate nextBirthday = birthDateObj.withYear(today.getYear());
            if (nextBirthday.isBefore(today)) {
                nextBirthday = nextBirthday.withYear(today.getYear() + 1);
            }
            Period period = Period.between(today, nextBirthday);
            long daysUntilBirthday = period.getDays();
            if(daysUntilBirthday != 0) {
                responseContent += "<h2>Hello "+ fullName +", there are " + Long.toString(daysUntilBirthday)
                        + " days until your birthday !</h2>";
            } else {
                responseContent += "<h2>Happy Birthday " + fullName + " !!!</h2>"
                + "<iframe width=\"548\" height=\"411\" src=\"https://www.youtube.com/embed/HjXxvooa-0g\" title=\"Joyeux Anniversaire - Patrick Sébastien\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";

            }

        }

        responseContent += "<a href='session-handler?action=logout'>destroy my session</a></div>";

        response.setContentType("text/html");
        response.getWriter().write(responseContent);
    }
}
