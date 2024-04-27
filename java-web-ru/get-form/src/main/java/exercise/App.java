package exercise;

import io.javalin.Javalin;
import java.util.List;
import exercise.model.User;
import io.javalin.rendering.template.JavalinJte;
import java.util.stream.Collectors;


public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            String term = ctx.queryParam("term");
            List<User> filteredUsers;
            if (term != null && !term.isEmpty()) {
                filteredUsers = USERS.stream()
                        .filter(user -> user.getFirstName().toLowerCase().startsWith(term.toLowerCase()))
                        .collect(Collectors.toList());
            } else {
                filteredUsers = USERS;
            }
            ctx.json(filteredUsers);
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
