import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculationTest {

    @Test
    public void testFindMaxPositivos() {
        assertEquals(4, Calculation.findMax(new int[]{1, 3, 4, 2}));
    }

    @Test
    public void testFindMaxNegativos() {
        assertEquals(-1, Calculation.findMax(new int[]{-12, -1, -3, -4, -2}));
    }

    @Test
    public void testFindMaxMixtos() {
        assertEquals(10, Calculation.findMax(new int[]{-10, -2, 0, 10, 5}));
    }
}


