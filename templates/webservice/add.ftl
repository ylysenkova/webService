<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>User</title>
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
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfvSI94U_zM47416kGoPv6XL-EGxfDb9wzhBaKCbPo5lGsSFxQQQ"
                         width="30"
                         height="30" class="d-inline-block align-top" alt="">
                    Add user
                </a>
            </nav>
    </div>
</header>
<div class="container">
    <form action="/user/add" method="POST">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">First Name</span>
            </div>
            <input class="form-control" aria-label="With textarea" name="firstName">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Last Name</span>
            </div>
            <input class="form-control" aria-label="With textarea" name="lastName">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" style="width: 100px">Salary</span>
            </div>
            <input class="form-control" aria-label="With textarea" name="salary">
        </div>
        <div class="button">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
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

