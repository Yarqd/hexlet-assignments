@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание статьи</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <h1>Создание статьи</h1>

    @if(page.getErrors() != null)
        <ul class="list-group">
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li class="list-group-item list-group-item-danger">${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название
                <input type="text" name="title" class="form-control" value="${page.getTitle()}" required>
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Содержимое
                <textarea name="content" class="form-control" rows="5" required>${page.getContent()}</textarea>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Создать статью</button>
    </form>
</div>
</body>
</html>
