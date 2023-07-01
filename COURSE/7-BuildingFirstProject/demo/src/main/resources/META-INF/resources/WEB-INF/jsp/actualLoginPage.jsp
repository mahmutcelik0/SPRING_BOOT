<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">


</head>
<body>
    <div class="container">
        Welcome to the LOGIN PAGE!
        <br>
        <form method="post">
            Name: <input type="text" name="name"> <br>
            Password: <input type="password" name="password"> <br>
            <pre>${error}</pre>

            <input type="submit" value="SUBMIT">
        </form>
    </div>

    <script src="webjars/jquery/3.6.2/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>


</body>
</html>