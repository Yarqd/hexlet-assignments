@import exercise.model.User
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(model("title", "List of Users"), content = `
    <h1>Users</h1>
    @if(page.getUsers().isEmpty()) {
        <p>No users found.</p>
    } @else {
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            @for(User user : page.getUsers()) {
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>
                        <a href="/users/${user.getId()}">View Details</a>
                    </td>
                </tr>
            }
            @endfor
            </tbody>
        </table>
    }
`)
