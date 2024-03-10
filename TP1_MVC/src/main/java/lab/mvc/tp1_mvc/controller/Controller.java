package lab.mvc.tp1_mvc.controller;

import lab.mvc.tp1_mvc.model.Person;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.RequestDispatcher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");

        Person person = new Person(firstName,lastName,birthDate,sex);

        request.setAttribute("person", person);

        LocalDate date = LocalDate.parse(person.getBirthDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate year1990 = LocalDate.of(1990, 1, 1); // January 1, 1990

        RequestDispatcher dispatcher = null;
        if (date.isBefore(year1990)) {
            dispatcher = getServletContext().getRequestDispatcher("/old.jsp");
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/young.jsp");
        }
        dispatcher.include(request, response);
    }
}
