<html>
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title><@title></@title></title>
    <style>
        html {
            font-family: Arial;
            min-height: 100%;
        }
        .btn-primary {
            background-color: #0000FF !important;
        }

        footer {
            position: absolute;
            width: 100%;

            display: flex;
            justify-content: center;
        }
        #login {
            background-color: #0000FF !important;
            margin-left: 550%;
        }
        #register {
            border-color: #0000FF !important;
            color: #0000FF;
        }
        .my_forms {
            margin-block-end: 0;
        }
        #main_menu {
            display: flex;
            flex-wrap: wrap;
            background: #0000FF;
            justify-content: space-evenly;
            width: 100%;
            height: 10%;
        }

        .menu_button {
            height: 100%;
            width: max-content;
            color: #FFFFFF;
            background: #0000FF;
            border: 0;
            flex-grow: 1;
        }
    </style>
</head>
<body>
<header>
    <div id="navigation">
        <nav class="navbar navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="${pageContext}/">
                    <img src="images/s_logo.png" width="96" height="32"/>
                </a>
                <#if login??>
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" id="profile_button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            ${first_name} ${last_name}
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="profile_button">
                            <li><a class="dropdown-item" href="${pageContext}/profile">Профиль</a></li>
                            <li><a class="dropdown-item" href="${pageContext}/logout">Выйти</a></li>
                        </ul>
                    </div>
                <#else>
                    <form method="get" action="${pageContext}/login" class="my_forms">
                        <button id="login" class="btn btn-primary">Логин</button>
                    </form>
                    <form method="get" action="${pageContext}/register" class="my_forms">
                        <button id="register" class="btn btn-outline-primary">Регистрация</button>
                    </form>
                </#if>
            </div>
        </nav>
    </div>
    <div id="main_menu">
        <form action="${pageContext}/" method="get">
            <button id="main" class="menu_button" type="submit">Главная</button>
        </form>
        <form action="${pageContext}/forum" method="get">
            <button class="menu_button" type="submit">Форум</button>
        </form>
        <form action="${pageContext}/universities" method="get">
            <button class="menu_button" type="submit">Список ВУЗов</button>
        </form>
        <form action="${pageContext}/reviews" method="get">
            <button class="menu_button" type="submit">Направления</button>
        </form>
        <form action="${pageContext}/about" method="get">
            <button class="menu_button" type="submit">О направлениях</button>
        </form>
    </div>
</header>
<@content></@content>
<footer class="footer py-3 bg-light">
    <div id="logos">
        <a href="https://github.com/MrRamir4eg"><img height="50" width="50" src="images/git_logo.png"
                                                     class="logos"/></a>
        <a href="https://www.youtube.com/c/Postupashki"><img height="50" width="50" src="images/youtube_logo.png"
                                                             class="logos"/></a>
        <a href="https://vk.com/durov"><img height="50" width="50" src="images/vk_logo.png" class="logos"/></a>
    </div>
</footer>
</body>
</html>
