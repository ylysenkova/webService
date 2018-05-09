<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Service</title>
</head>
<body>
<form action=edit.ftl method="get">

    <p>First Name <input value="${users.firstName}" type="text" name="firstName"></p>
    <p>Last Name <input value="${users.lastName}" type="text" name="lastName"></p>
    <p>Salary <input value="${users.salary?double?c}" type="number" name="salary" style="margin-left: 29px"></p>
    <input type="submit" value="Save"/>
</form>
</body>
</html>