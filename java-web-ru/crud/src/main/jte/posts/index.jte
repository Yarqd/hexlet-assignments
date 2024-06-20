<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Posts</title>
</head>
<body>
<h1>Posts</h1>
<ul>
    <!-- Перебор списка постов -->
    <#list page.posts as post>
    <li>
        <a href="${@NamedRoutes::postPath(post.getId())}">${post.getTitle()}</a>
    </li>
</#list>
</ul>
<!-- Ссылки на навигацию по страницам -->
<nav>
    <#if page.currentPage > 1>
    <a href="${@NamedRoutes::postsPath()}?page=${page.currentPage - 1}">Previous</a>
</#if>
<a href="${@NamedRoutes::postsPath()}?page=${page.currentPage + 1}">Next</a>
</nav>
</body>
</html>
