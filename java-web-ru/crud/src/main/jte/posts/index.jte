<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Posts</title>
</head>
<body>
<h1>Posts</h1>
<ul>
    <#list page.posts as post>
    <li>
        <a href="/posts/${post.getId()}">${post.getTitle()}</a> <!-- Используем статическую часть URL и id поста -->
    </li>
</#list>
</ul>
<nav>
    <#if page.currentPage > 1>
    <a href="/posts?page=${page.currentPage - 1}">Previous</a>
</#if>
<a href="/posts?page=${page.currentPage + 1}">Next</a>
</nav>
</body>
</html>
