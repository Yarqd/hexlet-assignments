package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import exercise.model.Post;
import exercise.Data;

@RestController
@RequestMapping("/api/users/{userId}/posts")
public class PostsController {

    // BEGIN
    private List<Post> posts = Data.getPosts();

    @GetMapping
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable int userId) {
        // Фильтруем посты по userId и собираем их в список
        List<Post> userPosts = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());

        // Возвращаем статус 200 OK и список постов
        return ResponseEntity.ok(userPosts);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post newPost) {
        // Устанавливаем userId из маршрута
        newPost.setUserId(userId);

        // Добавляем новый пост в список постов
        posts.add(newPost);

        // Возвращаем статус 201 Created и сам пост
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
    // END
}