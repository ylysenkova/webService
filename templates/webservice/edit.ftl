<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Service</title>
</head>
<body>
<form action="/user/edit" method="POST">
    <table>
        <tbody>
        <tr>
            <td>Id</td>
            <td><input value="${users.id}" name="id" style="border: white" readonly></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input value="${users.firstName}" type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input value="${users.lastName}" type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input value="${users.salary?double?c}" type="number" name="salary"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>

        </tbody>
    </table>
</form>
</body>
</html>