import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductOfArrayExcludingSelfTest {

    @Test
    void testNormalCase() {
        assertArrayEquals(new int[]{24, 12, 8, 6},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{1, 2, 3, 4}));
    }

    @Test
    void testWithZero() {
        assertArrayEquals(new int[]{0, 0, 8, 0},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{1, 2, 0, 4}));
    }

    @Test
    void testMultipleZeros() {
        assertArrayEquals(new int[]{0, 0, 0, 0},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{0, 2, 0, 4}));
    }

    @Test
    void testAllOnes() {
        assertArrayEquals(new int[]{1, 1, 1, 1},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{1, 1, 1, 1}));
    }

    @Test
    void testSingleElement() {
        assertArrayEquals(new int[]{1},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{5}));
    }

    @Test
    void testTwoElements() {
        assertArrayEquals(new int[]{7, 3},
                ProductOfArrayExcludingSelf.productOfArrayExcl(new int[]{3, 7}));
    }
}