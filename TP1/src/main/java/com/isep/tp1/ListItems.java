package com.isep.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "listItems", value = "/list-items")
public class ListItems extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> items = (List<String>) session.getAttribute("itemList");
        if (items == null) {
            items = new ArrayList<>();
        }

        String newItem = request.getParameter("newItem");
        if (newItem != null && !newItem.isEmpty()) {
            items.add(newItem);
        }
        session.setAttribute("itemList", items);
        response.sendRedirect("list-items");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> items = (List<String>) session.getAttribute("itemList");
        if (items == null) {
            response.sendRedirect("items.html");
            return;
        }

        String responseContent = "<head><link rel='stylesheet' href='CSS/styles.css' /></head>"
        + "<div class='centered'><h2>Your Items:</h2>";

        Map<String, Integer> itemCounts = new HashMap<>();
        for (String item : items) {
            Integer count = itemCounts.getOrDefault(item, 0); // Get existing count or 0 if not found
            itemCounts.put(item, count + 1); // Increment count
        }

        if (items.isEmpty()) {
            responseContent += "<p>No items in the list yet.</p>";
        } else {
            responseContent += "<ul>";
            for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
                String item = entry.getKey();
                int count = entry.getValue();
                responseContent += "<li>" + item + " (" + count + ")</li>";
            }
            responseContent += "</ul>";
        }

        responseContent += "<a href='items.html'>Add items to the list</a></div>";

        response.setContentType("text/html");
        response.getWriter().write(responseContent);
    }
}
