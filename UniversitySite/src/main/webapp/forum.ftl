<html>
<#include "base.ftl">
<#macro title>Forum</#macro>

<#macro content>
    <style>
        #discussions {
            display: flex;
            flex-direction: column;
            justify-content: center;
            margin-top: 2%;
        }

        #container {
            min-height: 100%;
            display: flex;
            flex-direction: column;
        }

        .write-me {
            max-height: 40px;
            margin-left: 2%;
            max-width: 40px;
        }

        #write_button {
            border: none;
            background-color: #FFFFFF;
            text-decoration: #FFFFFF;
        }

        #navigate {
            display: flex;
            justify-content: flex-end;
            width: 100%;
            height: 5%;
        }

        #search_bar {
            margin-top: 0.5%;
            height: 1%;
            width: 70%;
            display: flex;
            margin-right: 2%;
            justify-content: flex-end;
        }

        #title {
            width: 90%;
        }

        #description {
            width: 90%;
            height: 500px;
            overflow: scroll;
        }

        li {
            margin-top: 2%;
        }

        #write_new {
            display: flex;
            height: 1%;
            width: 30%;
        }

        #the_discussion {
            width: 70%;
            height: 100px;
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: lightgrey;
        }

        #the_user {
            display: flex;
            height: 50px;
            width: 100%;
        }

        #discussionImage {
            height: 50px;
            width: 50px;
        }

        #discussionImage img {
            height: 100%;
            width: 100%;
        }

        #user_name {
            height: 50px;
            width: auto;
        }

        #time {
            display: flex;
            justify-content: flex-end;
            text-align: center;
            height: 50px;
            width: 70%;
        }

        #discussionTitle {
            width: 100%;
            height: 50px;
        }

        ul {
            width: 100%;
            list-style-type: none;
        }
    </style>

    <script>
        function title_sym() {
            let title = document.getElementById("title").value;
            document.getElementById("title_n").textContent = title.length + '/70';
        }

        function description_sym() {
            let description = document.getElementById("description").value;
            document.getElementById("description_n").textContent = description.length + '/10000';
        }

        function doFilter() {
            let input, filter, ul, li, i, txtValue;
            input = document.getElementById('input');
            filter = input.value.toUpperCase();
            ul = document.getElementById("list");
            li = ul.getElementsByTagName('li');
            for (i = 0; i < li.length; i++) {
                txtValue = li[i].getElementsByClassName("filter-me")[0].textContent;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    li[i].style.display = "";
                } else {
                    li[i].style.display = "none";
                }
            }
        }
    </script>
    <div id="container">
        <div id="navigate">
            <div id="write_new">
                <#if login??>
                    <button type="button" id="write_button" data-bs-toggle="modal" data-bs-target="#exampleModal"><img
                                class="write-me" src="images/create_new.png"/></button>

                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Начать обсуждение</h5>
                                </div>
                                <form action="${pageContext}/forum" method="post">
                                    <div class="modal-body">
                                        <input onkeyup="title_sym()" id="title" name="title" type="text" maxlength="70"
                                               required/>
                                        <p id="title_n">0/70</p>
                                        <textarea onkeyup="description_sym()" id="description" name="description"
                                                  type="text" maxlength="10000" required></textarea>
                                        <p id="description_n">0/10000</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Закрыть
                                        </button>
                                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Отправить</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </#if>
            </div>
            <div id="search_bar">
                <input type="text" id="input" placeholder="Искать" onkeyup="doFilter()"/>
            </div>
        </div>
        <div id="discussions">
            <#if discussions??>
                <ul id="list">
                    <#list discussions as dis>
                        <li id="${dis.discussionDto.id}">
                            <a href="${pageContext}/discussion?discussionId=${dis.discussionDto.id}">
                                <div id="the_discussion">
                                    <div id="the_user">
                                        <div id="discussionImage">
                                            <#if dis.userDto.imageUrl??>
                                                <img src="${dis.userDto.imageUrl}"/>
                                            <#else>
                                                <img src="images/nouser.png"/>
                                            </#if>
                                        </div>
                                        <div id="user_name">
                                            ${dis.userDto.firstName} ${dis.userDto.lastName}
                                        </div>
                                        <div id="time">
                                            <div>${dis.discussionDto.timeCreated}</div>
                                        </div>
                                    </div>
                                    <div class="filter-me" id="discussionTitle">
                                        <h4>${dis.discussionDto.title}</h4>
                                    </div>
                                </div>
                            </a>
                        </li>
                    </#list>
                </ul>
            <#else>
                <div>Никто не пришел на встречу</div>
            </#if>
        </div>
    </div>
</#macro>
</html>
