@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание статьи</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Создать новую статью</h1>
    <form action="/articles" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Название статьи</label>
            <input type="text" class="form-control ${page.errors != null && !page.errors.get("title").isEmpty() ? "is-invalid" : ""}" id="title" name="title" value="${page.title}">
            <div class="invalid-feedback">
                ${page.errors != null ? page.errors.get("title") : ""}
            </div>
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Содержание статьи</label>
            <textarea class="form-control ${page.errors != null && !page.errors.get("content").isEmpty() ? "is-invalid" : ""}" id="content" name="content" rows="5">${page.content}</textarea>
            <div class="invalid-feedback">
                ${page.errors != null ? page.errors.get("content") : ""}
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Создать статью</button>
    </form>
</div>
</body>
</html>
