package exercise;

import io.javalin.Javalin;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create();
        // Передаем обработчик запроса
        app.get("/phones", ctx -> {
            List<String> res = Data.getPhones();
            ctx.contentType("application/json");
            ctx.json(res);
        });

        app.get("/domains", ctx -> {
            List<String> domains = Data.getDomains();
            ctx.contentType("application/json");
            ctx.json(domains);
        });

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
