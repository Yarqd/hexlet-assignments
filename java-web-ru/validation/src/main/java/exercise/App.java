package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.repository.ArticleRepository;
import exercise.util.Security;

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

        app.get("/articles/build", ctx -> {
            ctx.render("articles/build.jte", model("page", new BuildArticlePage("", "", null)));
        });

        app.post("/articles", ctx -> {
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");

            Map<String, List<ValidationError>> errors = ArticleRepository.validateArticle(title, content);
            if (!errors.isEmpty()) {
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", new BuildArticlePage(title, content, errors)));
            } else {
                Article article = new Article(title, Security.encrypt(content));
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
