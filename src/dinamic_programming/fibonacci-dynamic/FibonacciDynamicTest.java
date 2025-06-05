import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FibonacciDynamicTest {

    @Test
    public void testFibonacciZero() {
        assertEquals(0, FibonacciDynamic.getNthFibonacciDp(0));
    }

    @Test
    public void testFibonacciOne() {
        assertEquals(1, FibonacciDynamic.getNthFibonacciDp(1));
    }

    @Test
    public void testFibonacciTwo() {
        assertEquals(1, FibonacciDynamic.getNthFibonacciDp(2));
    }

    @Test
    public void testFibonacciFive() {
        assertEquals(5, FibonacciDynamic.getNthFibonacciDp(5));
    }

    @Test
    public void testFibonacciTen() {
        assertEquals(55, FibonacciDynamic.getNthFibonacciDp(10));
    }

    @Test
    public void testFibonacciTwenty() {
        assertEquals(6765, FibonacciDynamic.getNthFibonacciDp(20));
    }
}
