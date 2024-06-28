<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание пользователя</title>
</head>
<body>
<h1>Создание пользователя</h1>
<form action="/users" method="post">
    <div>
        <label>
            firstName
            <input type="text" required name="firstName" />
        </label>
    </div>
    <div>
        <label>
            lastName
            <input type="text" required name="lastName" />
        </label>
    </div>
    <div>
        <label>
            email
            <input type="email" required name="email" />
        </label>
    </div>
    <div>
        <label>
            password
            <input type="password" required name="password" />
        </label>
    </div>
    <input type="submit" value="Зарегистрировать" />
</form>
</body>
</html>
