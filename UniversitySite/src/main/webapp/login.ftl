<html>
<#include "login_base.ftl">

<#macro title>Login</#macro>
<style>
    #login_form {
        margin-top: 5%;
        display: flex;
        justify-content: center;
        flex-flow: column;
    }
    #log_me {
        background-color: #0000FF;
    }
</style>
<script>
    function register() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let remember_me = document.getElementById("remember_me").checked;
        $.post("${pageContext}/login", {
                email: email,
                password: password,
                remember_me: remember_me
            },
            function (response) {
                if (response === 'false') {
                    alert('Пользователь с таким email не существует');
                    return false;
                }
                window.location.replace("${pageContext}/profile");
            });
    }
</script>
<#macro user_form>
    <div id="login_form">
        <form action="/login" method="post">
            <input id="email" name="email" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                   placeholder="email" required/><br>
            <input id="password" type="password" placeholder="password" required/><br>
            <input id="remember_me" type="checkbox"/>
            <label class="form-check-label" for="remember_me">
                Запомнить меня
            </label><br>
            <input id="log_me" class="btn btn-primary" type="button" value="Войти" onclick="register()"/>
        </form>
    </div>
</#macro>
</html>
