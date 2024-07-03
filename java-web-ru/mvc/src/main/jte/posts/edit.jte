@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(
content = @`
    <h1>Редактирование поста</h1>
    <form action="${exercise.util.NamedRoutes.updatePostPath(page.getPost().getId())}" method="post">
        <div class="form-group">
            <label for="name">Имя</label>
            <input type="text" class="form-control" id="name" name="name" value="${page.getPost().getName()}">
            @if(page.getErrors().containsKey("name"))
                @for(var error : page.getErrors().get("name"))
                    <div class="text-danger">${error.getMessage()}</div>
                @endfor
            @endif
        </div>
        <div class="form-group">
            <label for="body">Тело</label>
            <textarea class="form-control" id="body" name="body">${page.getPost().getBody()}</textarea>
            @if(page.getErrors().containsKey("body"))
                @for(var error : page.getErrors().get("body"))
                    <div class="text-danger">${error.getMessage()}</div>
                @endfor
            @endif
        </div>
        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
`
)
