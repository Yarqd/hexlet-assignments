@import exercise.dto.users.UserPage
@param UserPage userPage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        dl {
            margin: 0;
            padding: 0;
        }
        dt {
            font-weight: bold;
            color: #666;
        }
        dd {
            margin: 0 0 10px 0;
            padding: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Details</h1>
        <dl>
            <dt>ID:</dt>
            <dd>${userPage.getUser().getId()}</dd>

            <dt>Name:</dt>
            <dd>${userPage.getUser().getName()}</dd>

            <dt>Email:</dt>
            <dd>${userPage.getUser().getEmail()}</dd>

            <dt>Phone:</dt>
            <dd>${userPage.getUser().getPhone()}</dd>
        </dl>
    </div>
</body>
</html>
