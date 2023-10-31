<html>
<#include "login_base.ftl">

<#macro title>Register</#macro>
<style>
    #remember_me {
        margin-top: 5%;
        display: flex;
        flex-flow: column;
        justify-content: center;
    }
    #register_button {
        background-color: #0000FF;
    }
</style>
<script>
    function check_params() {
        let email = document.getElementById("email").value;
        let regex = new RegExp('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$');
        if (!regex.test(email)) {
            alert('Неверный email')
            return false;
        }
        let password = document.getElementById("pass").value;
        if (password.length < 8) {
            alert('Пароль должен содержать 8 и более символов');
            return false;
        }
        let first_name = document.getElementById("first_name").value;
        regex = new RegExp('[а-яА-ЯёЁ]+');
        if (!regex.test(first_name)) {
            alert('Имя должно содержать только русские буквы');
            return false;
        }
        let last_name = document.getElementById("last_name").value;
        if (!regex.test(last_name)) {
            alert('Фамилия должно содержать только русские буквы');
            return false;
        }
        let date = new Date(document.getElementById("date").value);
        let constraint_date = new Date();
        if (date > constraint_date) {
            alert('Неверная дата рождения');
            return false;
        }
        let gender = document.getElementById("gender").value;
        let remember_me = document.getElementById("remember_me").checked;
        $.post("${pageContext}/register", {
                email: email,
                password: password,
                first_name: first_name,
                last_name: last_name,
                date: date.getDate() + '.' + (date.getMonth() + 1) + '.' + date.getFullYear(),
                gender: gender,
                remember_me: remember_me
            },
            function (response) {
                if (response === 'false') {
                    alert('Пользователь с таким email уже существует');
                    return false;
                }
                window.location.replace("${pageContext}/profile");
            });
    }
</script>
<#macro user_form>
    <div id="register_me">
        <br>
        <form action="/register" method="post">
            <input id="email" type="email" placeholder="email" required/><br>
            <input id="pass" type="password" placeholder="password" required/><br>
            <input id="first_name" type="text" placeholder="Имя" required/><br>
            <input id="last_name" type="text" placeholder="Фамилия" required/><br>
            <input id="date" type="date" required/><br>
            <select id="gender" required>
                <option>Мужской</option>
                <option>Женский</option>
                <option>Андроид</option>
            </select><br>
            <input id="remember_me" type="checkbox"/>
            <label class="form-check-label" for="remember_me">
                Запомнить меня
            </label><br>
            <input class="btn btn-primary" id="register_button" type="button" value="Зарегистрироваться" onclick="check_params()"/>
        </form>
    </div>
</#macro>
</html>
