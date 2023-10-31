<html>
<#include "base.ftl">

<style>
    #universal {
        display: flex;
        width: 100%;
        min-height: 100%;
        flex-direction: column;
        align-items: center;
    }

    .the_title {
        width: 100%;
        height: 10%;
        text-align: center;
        margin-top: 5%;
    }

    .the_description {
        width: 80%;
        margin-top: 2%;
    }

    .user_info {
        display: flex;
        height: 100px;
        width: 80%;
        margin-top: 2%;
        background-color: lightgrey;
    }

    .avatar img {
        height: 100px;
        width: 100px;

    }

    .time_of_creation {
        text-align: left;
    }

    .the_info1 {
        display: flex;
        align-items: center;
        width: 100%;
    }

    .user_name {
        width: 70%;
    }

    #comment {
        width: 60%;
        height: 40%;
        margin-top: 1%;
    }

    #write_comment {
        overflow: scroll;
        width: 100%;
        height: 60%;
    }

    .the-comment {
        display: flex;
        width: 70%;
        flex-direction: column;
        height: auto;
        background-color: lightgrey;
        margin-top: 5%;
    }

    .user_user img {
        height: 50px;
        width: 50px;
    }

    .user_user {
        height: 50px;
        width: 50px;
    }

    .u-info {
        display: flex;
        height: 50px;
        width: 100%;
    }

    .u-text-info {
        display: flex;
        justify-content: flex-end;
        width: 80%;
    }

    .u-text-info input {
        height: 50px;
        width: 100%;
        margin-left: 10%;
    }

    .u-name {
        width: 70%;
        height: 50px;
    }

    .u-time {
        width: 80%;
        text-align: right;
        height: 50px;
    }

</style>
<script>
    function description_sym() {
        let description = document.getElementById("write_comment").value;
        document.getElementById("check_typing").textContent = description.length + '/1000';
    }
</script>
<#macro title>${dis.discussionDto.title}</#macro>

<#macro content>
    <div id="universal">
        <div class="the_title">
            <h5>${dis.discussionDto.title}</h5>
        </div>
        <div class="the_description">
            ${dis.discussionDto.description}
        </div>
        <div class="user_info">
            <div class="avatar">
                <#if dis.userDto.imageUrl??>
                    <img src="${dis.userDto.imageUrl}"/>
                <#else>
                    <img src="images/nouser.png"/>
                </#if>
            </div>
            <div class="the_info1">
                <div class="user_name">${dis.userDto.firstName} ${dis.userDto.lastName}</div>
                <div class="time_of_creation">
                    Время написания: ${dis.discussionDto.timeCreated}
                </div>
            </div>
        </div>
        <#if login??>
            <form id="comment" action="${pageContext}/discussion" method="post">
                <textarea id="write_comment" maxlength="1000" required name="description"
                          onkeyup="description_sym()"></textarea>
                <input name="discussionId" type="text" style="display: none" value="${dis.discussionDto.id}"/>
                <p id="check_typing">0/1000</p>
                <input type="submit" class="btn btn-primary"/>
            </form>
        </#if>


        <#if comments??>
            <#list comments as c>
                <div class="the-comment">
                    <div class="u-info">
                        <div class="user_user">
                            <#if c.userDto.imageUrl??>
                                <img src="${c.userDto.imageUrl}"/>
                            <#else>
                                <img src="images/nouser.png"/>
                            </#if>
                        </div>
                        <div class="u-text-info">
                            <div class="u-name">
                                ${c.userDto.firstName} ${c.userDto.lastName}
                            </div>
                            <div class="u-time">
                                ${c.commentDto.timeCreated}
                            </div>
                        </div>
                    </div>
                    <div class="comm-desc">
                        ${c.commentDto.description}
                    </div>
                </div>
            </#list>
        </#if>
    </div>
</#macro>
</html>
