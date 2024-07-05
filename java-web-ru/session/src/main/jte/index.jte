@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <h1>Welcome to the home page!</h1>
    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Login</a>
    @else
        <p>Hello, ${page.getName().toString()}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <button type="submit">Logout</button>
        </form>
    @endif
`
)
