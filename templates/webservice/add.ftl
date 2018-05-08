<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Service</title>
</head>
<body>
<form action="/user/add" method="POST">
    <p> First Name <input type="text" name="firstName"/></p>
    <p> Last Name <input type="text" name="lastName"/></p>
    <p>Salary <input type="number" name="salary" style="margin-left: 29px"/></p>
    <form action="/users" method="post">
    <p><input type="submit" value="Add"/></p></form>
</form>
</body>
</html>