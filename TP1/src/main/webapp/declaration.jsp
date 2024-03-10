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
    <%!
        private int numEntries = 10;  // Declaration for numEntries

        private int randomInt(int range) {  // Declaration for randomInt function
            return(1 + ((int)(Math.random() * range)));
        }
    %>

    <h1>A random list from 1 to 100:</h1>
    <ul>
        <% for(int i=0; i<numEntries; i++) {
            out.println("<li>" + randomInt(100));  // Call randomInt within a Scriptlet
        } %>
    </ul>
    <a href='index.html'>Go back</a>
</div>
</body>
</html>