package exercise;

import io.javalin.Javalin;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import java.util.Map;

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
            ctx.render("articles/build.jte", model("page", new BuildArticlePage("", "", null)));
        });

        app.post("/articles", ctx -> {
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");

            if (title.length() < 2) {
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", new BuildArticlePage(title, content, Map.of(
                        "title", List.of("Название не должно быть короче двух символов")))));
                return;
            }

            if (content.length() < 10) {
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", new BuildArticlePage(title, content, Map.of(
                        "content", List.of("Статья должна быть не короче 10 символов")))));
                return;
            }

            if (ArticleRepository.existsByTitle(title)) {
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", new BuildArticlePage(title, content, Map.of(
                        "title", List.of("Статья с таким названием уже существует")))));
                return;
            }

            Article article = new Article(title, content);
            ArticleRepository.save(article);
            ctx.redirect("/articles");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
