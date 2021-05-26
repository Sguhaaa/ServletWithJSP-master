<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <title>Authorization</title>
</head>

<body>
    <form action="index" method="POST">
        <h6>Login: <input type="text" name="login" /> <br>${loginErr}</h6>
        <h6>Password: <input type="password" name="pass" /> <br>${passErr}</h6>
        <input type="submit" value="Sign in">
    </form>
    <div class="button">
        <p class="button"><a href="http://localhost:8080/ServletWithJSP_war/registration" target="_self">Sign UP</a></p>
    </div>
</body>
</html>