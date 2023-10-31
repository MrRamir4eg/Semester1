<html>
<#include "base.ftl">
<style>
#universal {
    min-height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}
#the_image {
    height: 5%;
    width: 50%;
}
#the_image img {
    height: 100%;
    width: 100%;
}
#name {
    width: 100%;
    text-align: center;
    height: 10%;
}
#description {
    width: 80%;
    align-content: center;
}
</style>
<#macro title>${name}</#macro>
<#macro content>
    <div id="universal">
        <div id="the_image">
            <img src="${addImg}"/>
        </div>
        <div id="name">
            <h4>${name}</h4>
        </div>
        <div id="description">
            ${description}
        </div>
    </div>
</#macro>
</html>
