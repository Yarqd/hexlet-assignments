@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@if(page.getErrors() != null)
    <ul>
        @for(var entry : page.getErrors().entrySet())
            @for(var error : entry.getValue())
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label for="title">Название статьи</label>
        <input type="text" id="title" name="title" value="${page.getTitle()}" required>
    </div>
    <div>
        <label for="content">Содержимое статьи</label>
        <textarea id="content" name="content" required>${page.getContent()}</textarea>
    </div>
    <button type="submit">Создать статью</button>
</form>
