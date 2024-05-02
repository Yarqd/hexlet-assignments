@import exercise.dto.users.UsersPage
@import exercise.dto.users.UserPage

@param UsersPage page

@template.layout.page(content = @`
    <h1>List of Users</h1>
    <a href="/users/new">New User</a>
    @for(var user : page.getUsers()) {
        <div>${user.getName()}</div>
        }
    @endfor
`)