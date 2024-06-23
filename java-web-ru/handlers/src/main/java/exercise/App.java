package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> {
            List<String> obj = Data.getPhones();
            ctx.json(obj);
        });
        app.get("domains", ctx -> {
            List<String> obj1 = Data.getDomains();
            ctx.json(obj1);
        });        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
