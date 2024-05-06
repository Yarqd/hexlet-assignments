package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            ctx.render("articles/build.jte");
        });

        app.post("/articles", ctx -> {
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");
            var page = new BuildArticlePage(title, content, null); // Создаем экземпляр страницы с данными формы и возможными ошибками

            try {
                if (title == null || title.length() < 2) {
                    page.addError("title", "Название не должно быть короче двух символов");
                }
                if (content == null || content.length() < 10) {
                    page.addError("content", "Статья должна быть не короче 10 символов");
                }
                if (ArticleRepository.existsByTitle(title)) {
                    page.addError("title", "Статья с таким названием уже существует");
                }

                if (page.hasErrors()) {
                    ctx.render("articles/build.jte", model("page", page));
                } else {
                    ArticleRepository.save(new Article(0, title, content));
                    ctx.redirect("/articles");
                }
            } catch (ValidationException e) {
                ctx.status(400);
                ctx.render("articles/build.jte", model("errors", e.getErrors()));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
