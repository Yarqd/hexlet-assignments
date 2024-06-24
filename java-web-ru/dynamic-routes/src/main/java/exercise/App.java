package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id"); // Извлекаем id как строку

            COMPANIES.stream()
                    .filter(comp -> comp.get("id").equals(id)) // Используем извлеченный id для фильтрации
                    .findFirst()
                    .ifPresentOrElse(
                            ctx::json, // Если компания найдена, возвращаем ее в формате JSON
                            () -> {
                                throw new NotFoundResponse("Company not found");
                            } // Если компания не найдена, выбрасываем исключение
                    );
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
