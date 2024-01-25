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
            List<Integer> list = new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> result = App.take(list, 5);
            assertTrue(result.isEmpty(1, 2, 3, 4, 5));
        }
        // END
    }
}
