<%@ page import="com.isep.tp1.bean.Person" %>
<%
    Person person = new Person();

    person.setFirstName(request.getParameter("firstName"));
    person.setLastName(request.getParameter("lastName"));
    person.setBirthDay(request.getParameter("birthDate"));
    person.setSex(request.getParameter("sex"));
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>TP1</title>
    <link rel="stylesheet" href="CSS/styles.css"/>
</head>
<body>
<div class="centered">
    <h2>Person Details</h2>
    <table>
        <tr><td>First Name</td><td><%= person.getFirstName() %></td></tr>
        <tr><td>Last Name</td><td><%= person.getLastName() %></td></tr>
        <tr><td>Birth Date</td><td><%= person.getBirthDay() %></td></tr>
        <tr><td>Sex</td><td><%= person.getSex() %></td></tr>
    </table>
    <a href="index.html">Go back</a>
</div>
</body>
</html>
