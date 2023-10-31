<html>
<#include "base.ftl">
<#macro title>${first_name} ${last_name}</#macro>
<style>
    #main_info {
        display: flex;
        min-height: 100%;
        margin-top: 5%;
    }

    #the_avatar1 img {
        max-width: 100%;
        max-height: 100%;
    }
    #the_avatar1 {
        width: 30%;
        height: 30%;
    }

    #user_avatar {
        display: flex;
        align-items: center;
        flex-direction: column;
        width: 50%;
    }

    .avatar {
        width: 200px;
        height: 200px;
    }

    #user_info {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 50%;
    }
    ::file-selector-button {
        color: #FFFFFF;
        background-color: #0000FF;
        border: 0;
    }
</style>
<#macro content>
    <div id="main_info">
        <div id="user_avatar">
            <div id="the_avatar1">
            <#if image_url??>
                <img class="avatar" src="${image_url}"/>
            <#else>
                <img class="avatar" src="images/nouser.png"/>
            </#if>
            </div>
            <br>
            <form method="post" action="${pageContext}/uploadAvatar" enctype="multipart/form-data">
                <input name="avatar" id="file" class="btn btn-primary" type="file" id="choose_avatar" accept="image/*" required/>
                <input type="submit" class="btn btn-primary"/>
            </form>
        </div>
        <div id="user_info">
            <form method="post" action="${pageContext}/profile">
                <input readonly value="${login}"/><br>
                <input name="new_first" value="${first_name}" pattern="[а-яА-ЯёЁ]+"/><br>
                <input name="new_last" value="${last_name}" pattern="[а-яА-ЯёЁ]+"/><br>
                <input class="btn btn-primary" type="submit" value="Изменить имя/фамилию"/>
            </form>
        </div>
    </div>
</#macro>
</html>
