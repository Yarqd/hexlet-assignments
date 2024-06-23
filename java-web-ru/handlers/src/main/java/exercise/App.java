package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.result(List<String> phones = Data.getPhones()));
        app.get("/domains", ctx -> ctx.result(List<String> domains = Data.getDomains()));
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
