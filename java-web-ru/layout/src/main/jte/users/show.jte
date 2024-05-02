@import exercise.dto.users.UsersPage
@import exercise.dto.users.UserPage
@import exercise.model.User

@param User user

@template.layout.page(content = @`
    <h1>User: ${user.getFirstName()} ${user.getLastName()}</h1>
    <p>Email: ${user.getEmail()}</p>
    <a href="/users">Back to Users List</a>
`)