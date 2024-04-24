package exercise;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        public static void main(String[] args) {
            Javalin app = Javalin.create(config -> {
                config.defaultContentType = "application/json"; // Устанавливаем по умолчанию тип контента JSON
            }).start(7070); // Запускаем сервер на порту 7070

            // Обработчик GET запросов на /phones
            app.get("/phones", App::handleGetPhones);

            // Обработчик GET запросов на /domains
            app.get("/domains", App::handleGetDomains);
        }

        // Метод для обработки GET запроса /phones
        private static void handleGetPhones(Context ctx) {
            List<String> phones = Data.getPhones(); // Получаем список телефонов
            ctx.json(phones); // Отправляем список телефонов в виде JSON
        }

        // Метод для обработки GET запроса /domains
        private static void handleGetDomains(Context ctx) {
            List<String> domains = Data.getDomains(); // Получаем список доменов
            ctx.json(domains); // Отправляем список доменов в виде JSON
        }
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
