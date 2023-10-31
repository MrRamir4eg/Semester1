<html>
<#include "base.ftl">
<#macro title>Reviews</#macro>
<style>
    #universal {
        display: flex;
        min-height: 100%;
        flex-direction: column;
        align-items: center;
    }

    #navigate {
        display: flex;
        width: 100%;
        height: 7%;
    }

    #filter {
        display: flex;
        justify-content: flex-end;
        width: 93%;
    }

    #add-new {
        height: 100%;
        width: 7%;
    }

    #add-new button {
        height: 100%;
        width: 80%;
        border: none;
        background-color: #FFFFFF;
        text-decoration: #FFFFFF;
    }

    #symbols {
        width: 90%;
        height: 120%;
        overflow: scroll;
    }

    .modal {
        height: 90%;
    }
    #all-comments {
        width: 80%;
        height: auto;
    }
    .real-comment {
        margin-top: 2%;
        height: auto;
        width: 100%;
    }
    .user-info1 {
        height: 50px;
        width: 100%;
        display: flex;
    }
    .time-created {
        width: 80%;
        height: 50px;
        text-align: right;
    }
    .user-info1 img {
        height: 50px;
        width: 50px;
    }
    .uni-info {
        display: flex;
    }
    .course-name {
        text-align: right;
        width: 50%;
    }
</style>
<script>
    function count() {
        let textarea = document.getElementById("symbols").value.length;
        document.getElementById("check-me-out").textContent = textarea + "/10000";
    }
    function doUniversityFilter () {
        let comments = document.getElementsByClassName("real-comment");
        let filter = document.getElementById("university-filter").value.toUpperCase();
        for (let i = 0; i < comments.length; i++) {
            let txtValue = comments[i].getElementsByClassName("uni-name")[0].textContent.trim();
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                comments[i].style.display = "";
            } else {
                comments[i].style.display = "none";
            }
        }
    }

    function doCourseFilter () {
        let comments = document.getElementsByClassName("real-comment");
        let filter = document.getElementById("course-filter").value.toUpperCase();
        for (let i = 0; i < comments.length; i++) {
            let txtValue = comments[i].getElementsByClassName("course-name")[0].textContent.trim();
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                comments[i].style.display = "";
            } else {
                comments[i].style.display = "none";
            }
        }
    }
</script>
<#macro content>
    <div id="universal">
        <div id="navigate">
            <div id="add-new">
                <#if login??>

                    <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <img id="save-me" width="25px" height="25px" src="images/create_new.png"/>
                    </button>

                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Отзыв на направление</h5>
                                </div>
                                <form action="${pageContext}/reviews" method="post">
                                    <div class="modal-body">
                                        <input name="uni" required list="university1">
                                        <datalist id="university1">
                                            <option value="">
                                                <#list universities as u>
                                            <option value="${u.name}">
                                                </#list>
                                        </datalist>
                                        <br>
                                        <input name="course" required list="course1">
                                        <datalist id="course1">
                                            <option value="">
                                                <#list courses as c>
                                            <option value="${c.codeName}">
                                                </#list>
                                        </datalist>
                                        <br>
                                        <label for="rec-me">Рекомедуете направление?</label>
                                        <select id="rec-me" name="recommend" required>
                                            <option>Да</option>
                                            <option>Нет</option>
                                        </select>
                                        <br>
                                        <textarea id="symbols" name="description" maxlength="10000" required
                                                  onkeyup="count()"></textarea>
                                        <p id="check-me-out">0/10000</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть
                                        </button>
                                        <button type="submit" class="btn btn-primary">
                                            Отправить
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </#if>
            </div>
            <div id="filter">
                <input id="university-filter" list="university" onkeyup="doUniversityFilter()">
                <datalist id="university">
                    <option value="">
                        <#list universities as u>
                    <option value="${u.name}">
                        </#list>
                </datalist>
                <input id="course-filter" list="course" onkeyup="doCourseFilter()">
                <datalist id="course">
                    <option value="">
                        <#list courses as c>
                    <option value="${c.codeName}">
                        </#list>
                </datalist>
            </div>
        </div>
        <div id="all-comments">
            <#if comments??>
                <#list comments as c>
                    <div class="real-comment" style="background: <#if c.courseCommentDto.positive==true>rgba(0,255,0,.25)<#else>rgba(255,0,0,.25)</#if>">
                        <div class="user-info1">
                            <#if c.userDto.imageUrl??>
                                <img src="${c.userDto.imageUrl}"/>
                            <#else>
                                <img src="images/nouser.png"/>
                            </#if>
                            <div class="user-name">
                                ${c.userDto.firstName} ${c.userDto.lastName}
                            </div>
                            <div class="time-created">
                                ${c.courseCommentDto.timeCreated}
                            </div>
                        </div>
                        <div class="uni-info">
                            <div class="uni-name">
                                ${c.universityDto.name}
                            </div>
                            <div class="course-name">
                                ${c.courseDto.codeName}
                            </div>
                        </div>
                        <div class="comm-description">
                            ${c.courseCommentDto.description}
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
    </div>
</#macro>
</html>
