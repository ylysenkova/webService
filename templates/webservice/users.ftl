<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Users</title>
    <style>
        .header {
            border-bottom: 1px solid #ccc;
        }
    </style>
</head>
<body>
<header class="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="https://techstory.in/wp-content/uploads/2015/07/Internet-users-India.jpg" width="30"
                         height="30" class="d-inline-block align-top" alt="">
                    UserService
                </a>
            </nav>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/users">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/add">Add</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Login</a>
                    </li>
                </ul>

            </div>
        </nav>
    </div>
</header>
<main>
    <section class="users container">
        <table class="table table-bordered">
            <thead>
            <tr style="text-align: center">
                <th scope="col">Id</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Salary</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
            <tr scope="row" style="text-align: center">
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.salary}</td>
                <td>
                    <div class="row">
                        <div class="col">
                            <a href="/user/edit/${user.id}" class="btn btn-outline-warning btn-block">Edit</a>
                        </div>
                        <div class="col">
                            <form action="/user/remove" method="post">
                                <input type="hidden" value="${user.id}" name="id">
                                <button type="submit" class="btn btn-outline-danger btn-block">Remove</button>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </section>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>