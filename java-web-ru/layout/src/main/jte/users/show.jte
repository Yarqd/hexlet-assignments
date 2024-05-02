@import exercise.dto.users.UserPage
@param UserPage page
@import exercise.dto.users.UsersPage
@import exercise.dto.users.UserPage
@import exercise.model.User

@param User user

@if(user != null) {
    @template.layout.page(content = @`
        <h1>User: ${user.getFirstName()} ${user.getLastName()}</h1>
        <p>Email: ${user.getEmail()}</p>
        <a href="/users">Back to Users List</a>
    `)
    } @else {
    @template.layout.page(content = @`
        <h1>User not found</h1>
        <a href="/users">Back to Users List</a>
    `)
    }
@endif
