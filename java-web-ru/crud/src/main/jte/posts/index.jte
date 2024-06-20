<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Posts</title>
</head>
<body>
<h1>Posts</h1>
<ul>
    <#list page.getPosts() as post>
    <li>
        <a href="/posts/${post.getId()}">${post.getTitle()}</a>
    </li>
</#list>
</ul>
<nav>
    <#if page.getCurrentPage() > 1>
    <a href="/posts?page=${page.getCurrentPage() - 1}">Previous</a>
</#if>
<a href="/posts?page=${page.getCurrentPage() + 1}">Next</a>
</nav>
</body>
</html>
