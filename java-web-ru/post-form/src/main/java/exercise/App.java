package exercise;

import io.javalin.Javalin;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        // GET /users/build
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

// POST /users
        app.post("/users", ctx -> {
            String firstName = StringUtils.capitalize(ctx.formParam("firstName"));
            String lastName = StringUtils.capitalize(ctx.formParam("lastName"));
            String email = StringUtils.trimToEmpty(ctx.formParam("email")).toLowerCase();
            String password = Security.encrypt(ctx.formParam("password"));

            User newUser = new User(firstName, lastName, email, password);
            UserRepository.save(newUser);
            ctx.redirect("/users");  // Перенаправление на страницу пользователей после сохранения
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
