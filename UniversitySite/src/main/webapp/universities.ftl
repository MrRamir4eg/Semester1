<html>
<#include "base.ftl">
<style>
    #universal {
        min-height: 100%;
    }
    ul {
        list-style-type: none;
    }
    #search_bar {
        display: flex;
        justify-content: flex-end;
        width: 100%;
        height: 10%;
    }
    .main {
        width: 80%;
        height: 200px;
        display: flex;
    }
    .the_image {
        height: 100%;
        width: 200px;
    }
    .the_text {
        display: flex;
        width: 60%;
        height: 100%;
        align-items: center;
        white-space: pre-wrap;
    }
    .uni_img {
        max-width: 90%;
        max-height: 90%;
    }
    #bar {
        margin-top: 1%;
        margin-right: 5%;
        height: 80%;
    }
    #universities {
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 90%;
    }
</style>
<script>
    function doFilter() {
        let input, filter, ul, li, h5, i, txtValue;
        input = document.getElementById('input');
        filter = input.value.toUpperCase();
        ul = document.getElementById("list");
        li = ul.getElementsByTagName('li');
        for (i = 0; i < li.length; i++) {
            txtValue = li[i].getElementsByClassName("the_text")[0].textContent;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
<#macro title>Universities</#macro>

<#macro content>
    <div id="universal">
        <div id="search_bar">
            <div id="bar">
                <input type="text" id="input" onkeyup="doFilter()" placeholder="Искать"/>
            </div>
        </div>
        <div id="universities">
            <ul id="list">
            <#if universities??>
                <#list universities as u>
                    <li>
                        <a href="${pageContext}/universityInfo?id=${u.id}">
                            <div class="main">
                                <div class="the_image">
                                    <img class="uni_img" src="${u.gerbImg}"/>
                                </div>
                                <div class="the_text">
                                    <h5>${u.name}</h5>
                                </div>
                            </div>
                        </a>
                    </li>
                </#list>
            </#if>
            </ul>
        </div>
    </div>
</#macro>
</html>
