package exercise.dto.articles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BuildArticlePage {
    private String title;
    private String content;
    // Инициализация поля errors при объявлении, что обеспечит его инициализацию в любом конструкторе
    private Map<String, List<String>> errors = new HashMap<>();

    public BuildArticlePage() {
        // Поле errors уже инициализировано выше, поэтому конструктор пуст
    }

    public BuildArticlePage(String title, String content) {
        this.title = title;
        this.content = content;
        // Поле errors уже инициализировано выше, поэтому конструктор не требует дополнительной инициализации
    }

    // Метод для добавления ошибок в карту
    public void addError(String field, String message) {
        errors.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
    }

    // Метод для проверки наличия ошибок
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}