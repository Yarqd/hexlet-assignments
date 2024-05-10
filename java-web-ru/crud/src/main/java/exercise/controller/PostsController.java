package exercise.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.PostsPage;

public class PostsController {

    public static void listPosts(Context ctx) {
        int page = 1;
        String pageParam = ctx.queryParam("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        int pageSize = 5;
        var posts = PostRepository.findAll(page, pageSize);
        int totalPosts = PostRepository.getEntities().size();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        var postsPage = new PostsPage(posts, page, totalPages);
        ctx.render("posts/index.jte", model("page", postsPage));
    }

    public static void showPost(Context ctx) {
        Long id;
        try {
            id = Long.parseLong(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            throw new NotFoundResponse("Invalid post ID format");
        }

        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse(
                "Entity with id = " + id + " not found"));


        ctx.render("posts/show.jte", model("post", post));
    }
}
