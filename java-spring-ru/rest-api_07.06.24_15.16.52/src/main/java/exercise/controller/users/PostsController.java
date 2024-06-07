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

    // Получаем список всех постов из данных
    private final List<Post> posts = Data.getPosts();

    // GET /api/users/{userId}/posts - список всех постов пользователя
    @GetMapping
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable int userId) {
        // Фильтруем посты по userId
        List<Post> userPosts = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());

        // Возвращаем статус 200 OK и список постов
        return ResponseEntity.ok(userPosts);
    }

    // POST /api/users/{userId}/posts - создание нового поста для пользователя
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Возвращаем статус 201 Created
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post newPost) {
        // Устанавливаем userId из маршрута
        newPost.setUserId(userId);

        // Добавляем новый пост в список постов
        posts.add(newPost);

        // Возвращаем статус 201 и сам пост
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
// END
