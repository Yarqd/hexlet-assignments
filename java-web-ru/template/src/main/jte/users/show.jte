@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Информация о пользователе</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <main>
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <p>Email: ${page.getUser().getEmail()}</p>
    </main>
</div>
</body>
</html>
