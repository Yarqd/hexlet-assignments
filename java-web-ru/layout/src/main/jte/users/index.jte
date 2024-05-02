@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>List of Users</h1>

    <a href="/users/new">New User</a>
    <table>
    @for(var user : page.getUsers()) {
        <tr>
            <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
        </tr>
        }
        </table>
    @endfor
        `,
        footer = @`
            <p>Iaroslav Rodionov</p>
            <p><a href="https://github.com/Yarqd">My GitHub profile</a></p>
        `
        )
