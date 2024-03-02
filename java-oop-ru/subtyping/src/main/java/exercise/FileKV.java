package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.io.IOException;
import java.util.stream.Collectors;


public class FileKV {
    private final Path filePath;

    public FileKV(Path filePath) {
        this.filePath = filePath;
    }

    public void set(String key, String value) throws IOException {
        Map<String, String> data = Files.lines(filePath)
                .map(line -> line.split("="))
                .collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
        data.put(key, value);
        Files.write(filePath, () -> data.entrySet().stream()
                .<CharSequence>map(entry -> entry.getKey() + "=" + entry.getValue())
                .iterator());
    }

    public String get(String key, String defaultValue) throws IOException {
        Map<String, String> data = Files.lines(filePath)
                .map(line -> line.split("="))
                .collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
        return data.getOrDefault(key, defaultValue);
    }

    public void unset(String key) throws IOException {
        Map<String, String> data = Files.lines(filePath)
                .map(line -> line.split("="))
                .collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
        data.remove(key);
        Files.write(filePath, () -> data.entrySet().stream()
                .<CharSequence>map(entry -> entry.getKey() + "=" + entry.getValue())
                .iterator());
    }
}

// END
