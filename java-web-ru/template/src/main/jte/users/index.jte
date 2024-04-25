@import exercise.model.User
@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Users</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Users</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            @for(User user : usersPage.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td> <!-- Исправлено здесь -->
                    <td><a href="/users/${user.getId()}">View Details</a></td>
                </tr>
            @endfor
        </tbody>
    </table>
</body>
</html>
