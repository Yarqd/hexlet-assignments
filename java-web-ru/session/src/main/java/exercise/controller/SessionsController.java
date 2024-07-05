package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte", model("page", new LoginPage(null, null)));
    }

    public static void create(Context ctx) {
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        var user = UsersRepository.findByName(username);
        if (user != null && user.getPassword().equals(Security.encrypt(password))) {
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
