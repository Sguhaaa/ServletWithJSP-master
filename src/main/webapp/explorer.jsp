<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <style>
        td {
            padding-right: 10px;
        }
        table{
            border: 4px double #333;
        }
        img {
            position: relative;
            top: 3px;
        }
    </style>
    <title>Directories</title>
</head>
<body>

<form action="explorer" method="post" style="float: right">
    <input type="submit" name="logout" value="Logout"/>
</form>

<div style="margin-left: 10px">${now}</div>
<h1 style="margin-left: 10px">${name}</h1>

<div class="content" style="margin-left: 10px">
    <table>
        <tr>
            <th>Файл</th>
            <th>Размер</th>
            <th>Дата</th>
        </tr>
        ${folders}
        ${files}
    </table>
</div>
</body>
</html>