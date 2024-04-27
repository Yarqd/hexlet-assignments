package exercise.dto.users;

import exercise.model.User;
import java.util.List;

// BEGIN
public class UsersPage {
    private List<User> users;
    private String title;

    public UsersPage(List<User> users, String title) {
        this.users = users;
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getTitle() {
        return title;
    }
}
// END
