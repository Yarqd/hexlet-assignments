package exercise.dto.articles;

import io.javalin.validation.ValidationError;
import java.util.Map;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

// BEGIN
@Getter
@NoArgsConstructor // Создает конструктор без аргументов для использования в Javalin.
@AllArgsConstructor // Создает конструктор со всеми полями, включая ошибки валидации.
public class BuildArticlePage {
    private String title; // Заголовок статьи
    private String content; // Содержание статьи
    private Map<String, List<ValidationError>> errors; // Ошибки валидации по каждому полю
}
// END
