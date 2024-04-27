@import exercise.model.User
@import exercise.dto.users.UsersPage
@import gg.jte.Content
@param UsersPage page

@template.layout.page(@Content`
    <h1>Users List</h1>
    <div class="list-group">
    @for(User user : page.getUsers()) {
        <a href="/users/${user.getId()}" class="list-group-item list-group-item-action">
            ${user.getFirstName()} ${user.getLastName()} - ${user.getEmail()}
        </a>
    }
    @if(page.getUsers().isEmpty()) {
        <div class="alert alert-warning" role="alert">
            No users found.
        </div>
    }
    </div>
`)
