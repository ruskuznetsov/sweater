<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    Login Page
    <@l.login "/login" />
    <div>
        <a href="/registration">Add new user</a>
    </div>
</@c.page>