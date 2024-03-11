<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.isep.tp1.bean.Person" %>
<jsp:useBean id="person" class="com.isep.tp1.bean.Person" scope="request"/>

<jsp:setProperty name="person" property="firstName" value="${param.firstName}"/>
<jsp:setProperty name="person" property="lastName" value="${param.lastName}"/>
<jsp:setProperty name="person" property="birthDay" value="${param.birthDate}"/>
<jsp:setProperty name="person" property="sex" value="${param.sex}"/>

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
        <tr><td>First Name</td><td><jsp:getProperty name="person" property="firstName"/></td></tr>
        <tr><td>Last Name</td><td><jsp:getProperty name="person" property="lastName"/></td></tr>
        <tr><td>Birth Date</td><td><jsp:getProperty name="person" property="birthDay"/></td></tr>
        <tr><td>Sex</td><td><jsp:getProperty name="person" property="sex"/></td></tr>
    </table>
    <a href="index.html">Go back</a>
</div>
</body>
</html>
