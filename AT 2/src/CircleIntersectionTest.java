import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleIntersectionTest {

    @ParameterizedTest
    @CsvSource({
            // x1, r1, x2, r2, expected
            "0, 5, 10, 5, 1",
            "0, 5, 5, 5, 2",
            "0, 5, 3, 3, 2",
            "0, 5, 2, 3, 1",
            "0, 5, 0, 5, -1",
            "0, 5, 1, 1, 0",
            "0, 5, 0, 3, 0",
            "-2, 4, 2, 4, 2",
            "-3, 5, 3, 5, 2"
    })
    public void testCalculateIntersectionPoints(int x1, int r1, int x2, int r2, int expected) {
        assertEquals(expected, CircleIntersection.calculateIntersectionPoints(x1, r1, x2, r2));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(1, CircleIntersection.calculateIntersectionPoints(0, 1000000, 500000, 500000));
    }
}