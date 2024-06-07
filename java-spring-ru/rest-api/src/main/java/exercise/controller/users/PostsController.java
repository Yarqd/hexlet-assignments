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
@RequestMapping("/api/users/{userId}/posts")
public class PostController {

    private final List<Post> posts = Data.getPosts();

    @GetMapping
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable int userId) {
        // Фильтруем посты по userId
        List<Post> userPosts = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userPosts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Возвращаем статус 201 Created
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post newPost) {
        newPost.setUserId(userId);

        posts.add(newPost);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
// END
