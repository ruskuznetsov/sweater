<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <div>
        <@l.logout "/logout" />
    </div>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Enter text"/>
            <input type="text" name="tag" placeholder="Tag"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type=" submit">Add</button>
        </form>
    </div>
    <div>
        <form method="post" action="filter">
            <input type="text" name="tag"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Filter</button>
        </form>
    </div>
    <div>List of Messages</div>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        No Messages
    </#list>
</@c.page>
