package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private Path filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Paths.get(filePath);
        try {
            String content = Utils.readFile(this.filePath);
            if (!content.isEmpty()) {
                initialData.forEach((key, value) -> {
                    if (!content.contains(key)) {
                        content += String.format("%s=%s%n", key, value);
                    }
                });
                Utils.writeFile(this.filePath, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set(String key, String value) {
        try {
            String content = Utils.readFile(filePath);
            content += String.format("%s=%s%n", key, value);
            Utils.writeFile(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unset(String key) {
        try {
            String content = Utils.readFile(filePath);
            content = content.replaceAll(String.format("%s=.+%n", key), "");
            Utils.writeFile(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get(String key, String defaultValue) {
        try {
            String content = Utils.readFile(filePath);
            String[] lines = content.split("\\r?\\n");
            for (String line : lines) {
                if (line.startsWith(key + "=")) {
                    return line.substring(key.length() + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        // Здесь можете реализовать конвертацию содержимого файла в Map
        return null;
    }
}
// END
