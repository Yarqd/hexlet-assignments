@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
    <h1>List of Users</h1>
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" required />
        <input type="submit" value="Search" />
    </form>
    @if(page.getUsers().isEmpty())
        <p>No users found</p>
    @else
        @for(var user : page.getUsers())
            <div>${user.getFirstName()} ${user.getLastName()}</div>
        @endfor
    @endif
`)
