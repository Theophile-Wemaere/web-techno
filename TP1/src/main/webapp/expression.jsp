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
    <h1>Your Random Number:</h1>
    <p>Here's a random number between 0 and 1 : <%= Math.random() %>
    </p>
    <a href='index.html'>Go back</a>
</div>
</body>
</html>