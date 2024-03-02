package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.io.IOException;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(Path filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.data = initialData;
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value); // Обновляем данные в памяти
        saveToFile(); // Сохраняем данные в файл
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }

    private void saveToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(filePath).toFile(), data); // Записываем данные в файл
        } catch (IOException e) {
            System.err.println("Failed to save data to file: " + e.getMessage());
        }
    }

    private void loadFromFile () {
        try {
            String content = Files.readString(filePath);
            data = Utils.unserialize(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// END
