@import exercise.model.User
@import java.util.List
@import java.util.Map
@param List<User> users
@param Map<String, Object> params

@template.layout.page(params) {
    <h1>List of Users</h1>
    @if(users.isEmpty()) {
        <p>No users found.</p>
    } @else {
        <div class="table-responsive">
            <table class="table table-striped table-sm">
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
                        <td>
                            <a href="/users/${user.getId()}">View Details</a>
                        </td>
                    </tr>
                } @endfor
                </tbody>
            </table>
        </div>
    }
}
