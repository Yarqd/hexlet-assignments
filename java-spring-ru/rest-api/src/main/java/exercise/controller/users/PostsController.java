package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api/users/{id}/posts")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping
    public List<Post> getUserPosts(@PathVariable int id) {
        // Используем простой цикл вместо стримов и Collectors.toList()
        List<Post> userPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getUserId() == id) {
                userPosts.add(post);
            }
        }
        return userPosts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createUserPost(@PathVariable int id, @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return post;
    }
}
// END
