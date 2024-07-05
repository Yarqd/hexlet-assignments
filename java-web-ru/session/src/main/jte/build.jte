@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    <h1>Login</h1>
    @if(page.getError() != null)
        <p style="color: red;">${page.getError()}</p>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${page.getName()}" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
`
)
