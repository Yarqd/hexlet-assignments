package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void setUp() throws Exception {
        Files.deleteIfExists(filepath); // Перед созданием удаляем файл, если он уже существует
        Files.createDirectories(filepath.getParent());
        Files.createFile(filepath);
    }


    @Test
    public void testFileKV() throws Exception {
        Map<String, String> initialData = Map.of("key1", "value1", "key2", "value2");
        KeyValueStorage storage = new FileKV(filepath.toString(), initialData);

        assertEquals("value1", storage.get("key1", "default"));
        assertEquals("value2", storage.get("key2", "default"));
        assertEquals("default", storage.get("unknown", "default"));

        // Удаление ключа
        storage.unset("key2");
        assertEquals("default", storage.get("key2", "default"));

        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        assertEquals(initialData, data);
    }
}
