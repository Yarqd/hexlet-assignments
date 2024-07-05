@import exercise.dto.LoginPage
@param LoginPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="@{exercise.util.NamedRoutes.loginPath()}" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${page.getName()}" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
    @if (page.getError() != null) {
    <p style="color: red;">${page.getError()}</p>
    }
</form>
</body>
</html>
