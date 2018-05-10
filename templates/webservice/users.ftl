<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Web Service</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style>
        table {
            width: 100%;
            color: black;
            border-collapse: collapse;

        }

        td, th {
            border: 1px solid black;
        }

        tr, th {
            background: antiquewhite;
            padding: 5px;
        }
    </style>
</head>
<body>
<form action="/user/add" method="GET">
    <p>
        <button type="submit">Add</button>
    </p>
</form>
<button type="submit" onclick="edit()">Edit</button>
<button type="submit" onclick="remove()">Remove</button>
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

       <tr id="${user.id}" onclick="store(this.id)">
           <td>${user.id}</td>
           <td>${user.firstName}</td>
           <td>${user.lastName}</td>
           <td>${user.salary}</td>
       </tr>
    </#list>
    </tr>
</table>
<script>
    var rowId;

    function store(id) {
        if (rowId !== undefined) {
            document.getElementById(rowId).style.backgroundColor = "";
        }
        rowId = id;
        document.getElementById(rowId).style.backgroundColor = "#7fffd4";
    }

    function edit() {
        if (rowId !== undefined) {
            window.location.href = "/user/edit?id=" + rowId;
        }
    }

    function remove() {
        if (rowId !== undefined) {
            var message = rowId;
            $.post('/user/remove?id=' + rowId, {id: rowId, message: message}, function () {
                window.location.reload(true)
            });


        }


    }
</script>
</body>
</html>