@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
</head>
<body>
<h1>Главная страница</h1>
@if(page.getName() == null)
    <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
@else
    <p>Добро пожаловать, ${page.getName()}!</p>
    <form action="${NamedRoutes.logoutPath()}" method="post">
        <button type="submit">Выйти</button>
    </form>
@endif
</body>
</html>
