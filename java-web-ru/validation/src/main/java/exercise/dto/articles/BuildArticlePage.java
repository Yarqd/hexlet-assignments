package exercise.dto.articles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildArticlePage {
    private String title;
    private String content;
    private Map<String, List<String>> errors;

    public BuildArticlePage(String title, String content) {
        this.title = title;
        this.content = content;
        this.errors = new HashMap<>();
    }

    public void addError(String field, String message) {
        errors.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
    }

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
}
