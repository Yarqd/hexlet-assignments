package exercise.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.util.List;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.PostsPage;
import exercise.util.NamedRoutes;

public class PostsController {

    public static void index(Context ctx) {
        int page = ctx.queryParam("page", Integer.class).getOrDefault(1);
        int size = 5;
        List<Post> posts = PostRepository.findAll(page, size);
        var postsPage = new PostsPage(posts, page, PostRepository.count());
        ctx.render("posts/index.jte", model("page", postsPage));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParam("id", Long.class).get();
        Post post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        ctx.render("posts/show.jte", model("post", post));
    }
}
