@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Пользователи</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
    <h1>Пользователи</h1>
    <form action="/users" method="get" class="mb-4">
        <div class="input-group">
            <input type="search" name="term" value="${page.getTerm()}" class="form-control" placeholder="Поиск пользователей..." required>
            <button class="btn btn-primary" type="submit">Искать</button>
        </div>
    </form>
@if(page.getUsers().isEmpty())
    <p>Совпадений не найдено.</p>
@else
    <div class="list-group">
        @for(var user : page.getUsers())
            <div class="list-group-item">
                <h5>${user.getFirstName()} ${user.getLastName()}</h5>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    </div>
@endif
    </div>
</body>
</html>