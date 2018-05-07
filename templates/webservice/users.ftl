<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Web Service</title>
    <style>
        table {
            width: 100%;
            background: antiquewhite;
            color: black;
            border-collapse: collapse;
        }

        td, th {
            border: 1px solid black;
            background: antiquewhite;
            padding: 5px;
        }
    </style>
</head>
<body>
<form action="/users.jsp" method="GET">
    <p>
        <button type="submit">Add</button>
        <button type="submit">Edit</button>
        <button type="submit">Remove</button>
    </p>

</form>
<table>
    <caption><strong>Users</strong></caption>
    <tr>
        <th>id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Salary</th>
    </tr>
<tr>
    <#list users as user>

       <tr>
           <td>${user.id}</td>
           <td>${user.firstName}</td>
           <td>${user.lastName}</td>
           <td>${user.salary}</td>
       </tr>
    </#list>
    </tr>
</table>
<p>Message: ${message}</p>

<p>Method: ${method}</p>

<p>URL: ${URL}</p>


<p>SessionId: ${sessionId}</p>

<p>Parameters: ${parameters}</p>
</body>
</html>