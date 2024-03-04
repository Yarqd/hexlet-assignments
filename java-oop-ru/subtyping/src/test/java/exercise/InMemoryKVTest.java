package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import java.util.HashMap;

class InMemoryKVTest {

    @Test
    void inMemoryKVTest() {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.get("key", "default")).isEqualTo("10");

        storage.set("key2", "value2");
        storage.set("key", "value");

        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
        assertThat(storage.toMap()).isEqualTo(Map.of("key2", "value2"));
    }

    @Test
    void mustBeImmutableTest() {
        Map<String, String> initial = Map.of("key", "10");

        KeyValueStorage storage = new InMemoryKV(initial);

        // Проверяем, что исходная карта остается неизменной
        assertThat(initial).isEqualTo(Map.of("key", "10"));

        // Должно быть возможным получить копию карты и изменять ее без влияния на исходную карту
        Map<String, String> map = storage.toMap();
        map.put("key2", "value2");
        assertThat(initial).isEqualTo(Map.of("key", "10"));
    }
}
