package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
            List<Integer> list = new ArrayList<>();
            List<Integer> result = ListUtils.take(list, 5);
            assertTrue(result.isEmpty());
        }
        // END
    }
}
