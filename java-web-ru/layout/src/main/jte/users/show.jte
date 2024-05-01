@import org.example.hexlet.dto.User
@param User user

@template.layout.page(content = @`
    <h1>User: ${user.getName()}</h1>
    <p>Email: ${user.getEmail()}</p>
    <a href="/users">Back to Users List</a>
`)