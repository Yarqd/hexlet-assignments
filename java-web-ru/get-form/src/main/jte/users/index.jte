@import exercise.model.User
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(model("title", "User List")) {
    <h1>Users List</h1>
    <form action="/users" method="GET">
        <input type="text" name="term" value="${page.getTerm()}" placeholder="Search by first name">
        <button type="submit">Search</button>
    </form>

    @if(page.getUsers().isEmpty()) {
        <p>No users found.</p>
    } @else {
        <table class="table">
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
}
