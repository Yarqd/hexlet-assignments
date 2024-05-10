package exercise.controller;

import io.javalin.http.Context;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.PostsPage;

public class PostsController {

    public static void listPosts(Context ctx) {
        int page = ctx.queryParam("page", Integer.class).getOrDefault(1);
        int pageSize = 5; // Пример размера страницы
        var posts = PostRepository.findAll(page, pageSize);
        int totalPosts = PostRepository.getEntities().size();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        var postsPage = new PostsPage(posts, page, totalPages);
        ctx.render("posts/index.jte", model("page", postsPage));
    }

    public static void showPost(Context ctx) {
        Long id = ctx.pathParam("id", Long.class).get();
        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse(
                "Entity with id = " + id + " not found"));
        ctx.render("posts/show.jte", model("post", post));
    }
}
