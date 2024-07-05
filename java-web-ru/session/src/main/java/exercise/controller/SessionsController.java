package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.model.User;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte", model("page", new LoginPage(null, null)));
    }

    public static void create(Context ctx) {
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = UsersRepository.findByName(username);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("currentUser", username);
            ctx.redirect(exercise.util.NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(username, "Wrong username or password");
            ctx.render("sessions/build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(exercise.util.NamedRoutes.rootPath());
    }
    // END
}
