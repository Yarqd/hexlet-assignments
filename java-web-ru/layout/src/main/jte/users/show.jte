@import exercise.model.User
@import java.util.Map
@param User user
@param Map<String, Object> params

@template.layout.page(model("title", "User Details")) {
    <h1>User Details</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
            <p class="card-text">${user.getEmail()}</p>
        </div>
    </div>
}
