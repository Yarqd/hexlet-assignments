package exercise.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.util.List;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.PostsPage;
import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {

    public static void listPosts(Context ctx) {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int size = 5; // Размер страницы пагинации
        List<Post> posts = PostRepository.findAll(page, size);
        var postsPage = new PostsPage(posts, page, PostRepository.count());
        ctx.render("posts/index.jte", model("page", postsPage));
    }

    public static void showPost(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        ctx.render("posts/show.jte", model("post", post));
    }
}
