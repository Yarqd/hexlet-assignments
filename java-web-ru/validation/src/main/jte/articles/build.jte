@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@if(page.getErrors() != null)
    <ul>
        @for(var entry : page.getErrors().entrySet())
            @for(var error : entry.getValue())
                <li>${error}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Название статьи
            <input type="text" name="title" value="${page.getTitle()}" />
        </label>
    </div>
    <div>
        <label>
            Содержимое статьи
            <textarea name="content">${page.getContent()}</textarea>
        </label>
    </div>
    <input type="submit" value="Создать статью" />
</form>
