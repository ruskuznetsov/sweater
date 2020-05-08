<#import "parts/common.ftlh" as c>
<#import "parts/registration.ftlh" as r>
<@c.page>
    Add new user
    ${message!""}
    <@r.registration "/registration" />
</@c.page>
