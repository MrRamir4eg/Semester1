<html>
<#include "base.ftl">
<#macro title>About Courses</#macro>
<style>
    #ubiquitous {
        display: flex;
        margin-top: 5%;
        width: 50%;
        align-self: center;
        min-height: 100%;
    }

    li {
        margin-bottom: 1%;
    }

    ul {
        list-style-type: "\1F599";
    }
</style>
<#macro content>
    <div id="ubiquitous">
        <ul>
            <#if courses??>
                <#list courses as course>
                    <li>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#courseModal${course.id}">
                            ${course.codeName} ${course.name}
                        </button>

                        <div class="modal fade" id="courseModal${course.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">${course.codeName} ${course.name}</h5>
                                    </div>
                                    <div class="modal-body">
                                        ${course.description}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </#list>
            <#else>
                Грусть, печаль, тоска
            </#if>
        </ul>
    </div>
</#macro>
</html>
