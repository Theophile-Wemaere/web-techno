<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TP1</title>
    <link rel="stylesheet" href="CSS/styles.css"/>
</head>
<body>
<h1>Simple POST form</h1>
<form action="user-controller" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" name="firstName" id="firstName" required>
    <br>
    <label for="lastName">Last Name:</label>
    <input type="text" name="lastName" id="lastName" required>
    <br>
    <label for="birthDate">Birth Date (MM/DD/YYYY):</label>
    <input type="date" name="birthDate" id="birthDate" required>
    <br>
    <br>
    <label>Sex:</label>
    <br>
    <div class="row">
        <input type="radio" name="sex" id="male" value="male" required>
        <label for="male">Male</label>
    </div>
    <br>
    <div class="row">
        <input type="radio" name="sex" id="female" value="female" required>
        <label for="female">Female</label>
    </div>
    <br>
    <br>
    <input type="submit" style="margin-top: 20px;" value="Submit">
    <a href="read-cookie" style="margin-top: 40px;font-size: 20px;text-align: center">
        Read your cookies, click here
    </a>
    <a href="count-cookie" style="margin-top: 40px;font-size: 20px;text-align: center">
        Count your cookies
    </a>
</form>
</body>
</html>