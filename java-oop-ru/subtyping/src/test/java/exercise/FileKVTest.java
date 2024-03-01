package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        private static final String TEST_FILE_PATH = "src/test/resources/testdata.txt";

        @BeforeEach
        void setUp() throws IOException {
            // Удаляем файл перед каждым тестом
            Files.deleteIfExists(Path.of(TEST_FILE_PATH));
        }

        @Test
        void testFileKV() {
            // Создаем объект FileKV
            FileKV storage = new FileKV(TEST_FILE_PATH, Map.of("key1", "value1", "key2", "value2"));

            // Проверяем значения по ключам
            assertEquals("value1", storage.get("key1", ""));
            assertEquals("value2", storage.get("key2", ""));

            // Изменяем значения и убеждаемся, что они сохраняются в файле
            storage.set("key1", "newValue1");
            storage.set("key3", "value3");

            // Создаем новый объект FileKV и проверяем, что изменения сохранились
            FileKV newStorage = new FileKV(TEST_FILE_PATH, Map.of());
            assertEquals("newValue1", newStorage.get("key1", ""));
            assertEquals("value2", newStorage.get("key2", ""));
            assertEquals("value3", newStorage.get("key3", ""));
        }
    }

    // END
}
