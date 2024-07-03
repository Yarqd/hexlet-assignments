@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <h1>Список постов</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        @for (var post : page.getPosts())
            <tr>
                <td>${post.getId()}</td>
                <td>${post.getName()}</td>
                <td><a href="/posts/${post.getId()}">Просмотр</a></td>
            </tr>
        @endfor
        </tbody>
    </table>
    <div>
        @if (page.getCurrentPage() > 1)
            <a href="${exercise.util.NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}" class="btn btn-primary">Назад</a>
        @endif
        @if (page.getPosts().size() == page.getPageSize())
            <a href="${exercise.util.NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}" class="btn btn-primary">Вперед</a>
        @endif
    </div>
`
)
