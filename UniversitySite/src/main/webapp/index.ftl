<html>
<#include "base.ftl"/>
<#macro title>VuzHUB</#macro>
<style>
    #hello {
        display: flex;
        margin-top: 2%;
        flex-direction: column;
        align-items: center;
    }
    #vid {
        margin-top: 5%;
        margin-bottom: 10%;
    }
    .phrase {
        width: 50%;
    }
</style>
<#macro content>
    <div id="hello">
    <h2>Добро пожаловать!</h2><br>
    <div class="phrase">    Наш сайт создан для обсуждений вузов и их направлений. Если у Вас есть сомнения в поступлении и выборе ВУЗа, то предлагаем посмотреть следующее видео:</div>
    <iframe id="vid" allowfullscreen="allowfullscreen" src="https://www.youtube.com/embed/osx4HxUIoDg?autoplay=0">Здесь должно быть видео</iframe>
    </div>
</#macro>
</html>
