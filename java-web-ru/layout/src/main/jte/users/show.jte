@import exercise.model.User
@import gg.jte.Content
@param User user

@template.layout.page(@Content`
    <h1>User Details</h1>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
            <p class="card-text">${user.getEmail()}</p>
        </div>
    </div>
`)
