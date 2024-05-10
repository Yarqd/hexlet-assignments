package exercise.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.PostRepository;
import exercise.dto.posts.PostsPage;

public class PostsController {

    public static void listPosts(Context ctx) {
        String pageStr = ctx.queryParam("page", "1");
        int page = Integer.parseInt(pageStr);

        int pageSize = 5;
        var posts = PostRepository.findAll(page, pageSize);
        int totalPages = (int) Math.ceil((double) PostRepository.getEntities().size() / pageSize);

        var postsPage = new PostsPage(posts, page, totalPages);
        ctx.render("posts/index.jte", model("page", postsPage));
    }

    public static void showPost(Context ctx) {
        Long id = Long.parseLong(ctx.pathParam("id"));
        var post = PostRepository.find(id).orElseThrow(() ->
                new NotFoundResponse("Entity with id = " + id + " not found"));
        ctx.render("posts/show.jte", model("post", post));
    }
}
