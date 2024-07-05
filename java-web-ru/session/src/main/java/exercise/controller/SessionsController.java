package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;
import exercise.util.NamedRoutes;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte", model("page", new LoginPage("", "")));
    }

    // Процесс логина
    public static void create(Context ctx) {
        var nickname = ctx.formParam("name");
        var password = ctx.formParam("password");

        System.out.println("Nickname: " + nickname);
        System.out.println("Password: " + password);

        var user = UsersRepository.findByName(nickname);
        if (user == null || !user.getPassword().equals(encrypt(password))) {
            ctx.render("build.jte", model("page", new LoginPage(nickname, "Wrong username or password")));
            return;
        }

        ctx.sessionAttribute("currentUser", nickname);
        ctx.redirect(NamedRoutes.rootPath()); // Редирект после успешного логина
    }

    // Процесс выхода из аккаунта
    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
