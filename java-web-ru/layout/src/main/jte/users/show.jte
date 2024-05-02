@import exercise.dto.users.UserPage
@param UserPage page

@if(page.getUser() != null) {
    @template.layout.page(content = @`
        <h2>User</h2>
        <table>
            <thead>
            <tr>
                <th>FirstName LastName</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
                <td>${page.getUser().getEmail()}</td>
            </tr>
            </tbody>
        </table>
        <a href="/users">Back to Users List</a>
    `, footer = @`
        <p>Alina Tarasova</p>
        <p><a href="https://github.com/Yarqd">My GitHub profile</a></p>
    `)
    } @else {
@template.layout.page(content = @`
    <h1>User not found</h1>
    <a href="/users">Back to Users List</a>
`)
}
