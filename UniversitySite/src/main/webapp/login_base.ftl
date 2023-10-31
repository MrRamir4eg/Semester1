<html>
<head>
    <meta charset="UTF-8">
    <title><@title></@title></title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/base.css"/>
    <style>
        .user_form {
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>
<div id="navigation">
    <nav class="navbar navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="${pageContext}/">
                <img src="images/s_logo.png" width="96" height="32"/>
            </a>
        </div>
    </nav>
</div>
<div class="content">
    <div class="user_form">
        <@user_form></@user_form>
    </div>
</div>
</body>
</html>
