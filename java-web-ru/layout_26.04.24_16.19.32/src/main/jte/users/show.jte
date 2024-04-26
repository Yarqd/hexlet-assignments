@import exercise.model.User
@import java.util.Map
@import java.util.HashMap
@param User user

@{
    Map<String, Object> params = new HashMap<>();
    params.put("title", "User Details - " + user.getFirstName() + " " + user.getLastName());
}

@template.layout.page(params) {
    <h1>User Details</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
            <p class="card-text">${user.getEmail()}</p>
        </div>
    </div>
}
