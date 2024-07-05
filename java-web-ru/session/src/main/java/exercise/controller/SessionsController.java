package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;
import exercise.util.NamedRoutes;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte", model("page", new LoginPage(null, null)));
    }

    public static void create(Context ctx) {
        var username = ctx.formParam("username");
        var password = ctx.formParam("password");

        User user = UsersRepository.findByName(username);
        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("currentUser", username);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(username, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
