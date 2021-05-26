<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <title>Регистрация</title>
</head>
<body>
<form action="registration" method="POST">
    Login: <input type="text" name="login" value="${login}"/>${loginErr}<br><br>
    Password: <input type="password" name="pass1" value="${pass1}"/>${pass1Err}<br><br>
    Retry password: <input type="password" name="pass2" value="${pass2}"/>${pass2Err}<br><br>
    Email: <input type="email" name="email" value="${email}"/>${emailErr}<br><br>
    <input type="submit" value="Sign up">
</form>
</body>
</html>