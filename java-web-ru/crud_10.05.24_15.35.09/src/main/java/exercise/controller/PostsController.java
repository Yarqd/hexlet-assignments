package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        if (PostRepository.find(id).isEmpty()) {
            ctx.status(404).result("age not found");
        } else {
            var post = PostRepository.find(id).get();
            var page = new PostPage(post);
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
        }
    }

    public static void index(Context ctx) {

        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int per = 5;

        page = page == 0 ? 1 : page;

        var posts = PostRepository.getEntities()
                .stream()
                .skip((long) Math.max(page - 1 , 0) * per)
                .limit(per)
                .collect(Collectors.toList());

        var postsPage = new PostsPage(posts, page);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }
    // END
}
