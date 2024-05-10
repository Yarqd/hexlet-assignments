package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        User user = new User(firstName, lastName, email, Security.encryptPassword(password));
        user.setToken(Security.generateToken());
        UserRepository.save(user);

        ctx.cookie("token", user.getToken());

        ctx.redirect(NamedRoutes.userPath(user.getId().toString()));
    }

    public static void show(Context ctx) {
        Long id = Long.parseLong(ctx.pathParam("id"));
        User user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("User not found"));

        String token = ctx.cookie("token");
        if (token == null || !token.equals(user.getToken())) {
            ctx.redirect(NamedRoutes.usersBuildPath());
        } else {
            ctx.render("users/show.jte", model("page", new UserPage(user)));
        }
    }
    // END
}
