<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TP1</title>
    <link rel="stylesheet" href="CSS/styles.css"/>
</head>
<body>
<div class="centered">
    <h1>Server Information:</h1>
    <%
        Date currentTime = new Date();
        String serverIP = request.getRemoteHost();
    %>
    <p>Current Time: <%= currentTime %></p>
    <p>Server IP Address: <%= serverIP %></p>
    <a href='index.html'>Go back</a>
</div>
</body>
</html>