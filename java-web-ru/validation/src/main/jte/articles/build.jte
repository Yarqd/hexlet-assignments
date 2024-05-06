@import exercise.dto.articles.BuildArticlePage
@param page BuildArticlePage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание статьи</title>
</head>
<body>
<h1>Создание новой статьи</h1>

@if (page.hasErrors())
<div class="errors">
    <ul>
        @for (entry : page.getErrors().entrySet())
        <li>${entry.getKey()}:</li>
        @for (error : entry.getValue())
        <li>${error}</li>
        @endif
        @endif
    </ul>
</div>
@endif

<form action="/articles" method="post">
    <div>
        <label for="title">Название статьи</label>
        <input type="text" id="title" name="title" value="${page.getTitle()}" required>
    </div>
    <div>
        <label for="content">Содержимое</label>
        <textarea id="content" name="content" required>${page.getContent()}</textarea>
    </div>
    <div>
        <button type="submit">Создать</button>
    </div>
</form>
</body>
</html>
