@import exercise.model.User
@import java.util.List
@param List<User> users

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>
    <h1>List of Users</h1>
    @if(users.isEmpty()) {
        <p>No users found.</p>
    } @else {
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            @for(User user : users) {
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td><a href="/users/${user.getId()}">View Details</a></td>
                </tr>
            }
            @endfor
            </tbody>
        </table>
    }
    @endif
</body>
</html>
