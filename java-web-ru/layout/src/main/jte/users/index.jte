@import exercise.model.User
@import exercise.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Users</title>
</head>
<body>
    <h1>Users</h1>
    @if(page.getUsers().isEmpty()) {
        <p>No users found.</p>
    } @else {
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
            @for(User user : page.getUsers()) {
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            }
            @endfor
            </tbody>
        </table>
    }
    @endif
</body>
</html>
