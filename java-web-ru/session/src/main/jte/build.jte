@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    <h1>Login</h1>
    <form action="/sessions" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${page.getName() != null ? page.getName().toString() : ""}" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
        @if(page.getError() != null)
            <p style="color: red;">${page.getError()}</p>
        @endif
    </form>
`
)
