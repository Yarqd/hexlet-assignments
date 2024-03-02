package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testFileKV() {
        // Подготавливаем тестовые данные
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");

        // Создаем экземпляр FileKV
        FileKV storage = new FileKV(filepath.toString(), initialData);

        // Проверяем, что данные успешно записались в файл
        assertTrue(Files.exists(filepath));

        // Проверяем, что данные можно получить
        assertEquals("value1", storage.get("key1", ""));
        assertEquals("value2", storage.get("key2", ""));

        // Проверяем, что при установке новых значений данные сохраняются в файл
        storage.set("key3", "value3");
        assertEquals("value3", storage.get("key3", ""));
        assertTrue(Files.exists(filepath));

        // Проверяем, что при удалении ключа данные сохраняются в файл
        storage.unset("key2");
        assertNull(storage.get("key2", null));
        assertTrue(Files.exists(filepath));

        // Проверяем, что метод toMap работает корректно
        Map<String, String> data = storage.toMap();
        assertEquals(2, data.size());
        assertEquals("value1", data.get("key1"));
        assertEquals("value3", data.get("key3"));
    }
    // END
}
