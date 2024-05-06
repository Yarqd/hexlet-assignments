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
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");
            var page = new BuildArticlePage(title, content, null);

            Map<String, List<ValidationError>> errors = ctx.validate(() -> page)
                    .check("title", p -> p.getTitle() != null && p.getTitle().length() >= 2, "Название не должно быть короче двух символов")
                    .check("content", p -> p.getContent() != null && p.getContent().length() >= 10, "Статья должна быть не короче 10 символов")
                    .check("title", p -> ArticleRepository.findByTitle(p.getTitle()) == null, "Статья с таким названием уже существует")
                    .getErrors();

            if (errors.isEmpty()) {
                ArticleRepository.addEntity(new Article(title, content));
                ctx.redirect("/articles");
            } else {
                page.setErrors(errors);
                ctx.render("articles/build.jte", model("page", page));
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
