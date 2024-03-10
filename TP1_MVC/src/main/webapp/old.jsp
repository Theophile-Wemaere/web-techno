<%@ page import="lab.mvc.tp1_mvc.model.Person" %>
<jsp:useBean id="person" type="lab.mvc.tp1_mvc.model.Person" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TP1</title>
    <link rel="stylesheet" href="CSS/styles.css"/>
</head>
<body>
<div class="centered">
    <h2>Person Details : Old (born before 1990)</h2>
    <table>
        <tr><td>First Name</td><td><jsp:getProperty name="person" property="firstName" /></td></tr>
        <tr><td>Last Name</td><td><jsp:getProperty name="person" property="lastName" /></td></tr>
        <tr><td>Birth Date</td><td><jsp:getProperty name="person" property="birthDay" /></td></tr>
        <tr><td>Sex</td><td><jsp:getProperty name="person" property="sex" /></td></tr>
    </table>
    <a href="index.html">Go back</a>
</div>
</body>
</html>
