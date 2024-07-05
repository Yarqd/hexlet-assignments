@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
@if(page.getError() != null && !page.getError().isEmpty())
    <p style="color: red;">${page.getError()}</p>
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" name="nickname" placeholder="Nickname" value="${page.getName()}" required>
    <input type="password" name="password" placeholder="Password" required>
    <button type="submit">Login</button>
</form>
</body>
</html>
