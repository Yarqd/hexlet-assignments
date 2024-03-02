package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Paths.get(filePath);
        this.data = initialData;
        // При создании экземпляра класса сразу сохраняем данные в файл
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveToFile();
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }

    // Метод для сохранения данных в файл
    private void saveToFile() {
        try {
            Utils.writeFile(filePath.toString(), Utils.serialize(data));
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }
}
// END
