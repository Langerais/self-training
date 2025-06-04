import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumNumberOfCoinsTest {

    @Test
    public void testSimpleCase() {
        int[] coins = {1, 2, 5};
        int target = 11;
        int expected = 3; // 5 + 5 + 1
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }

    @Test
    public void testExactCoinMatch() {
        int[] coins = {2, 4, 6};
        int target = 4;
        int expected = 1; // 4
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }

    @Test
    public void testSingleCoinType() {
        int[] coins = {3};
        int target = 9;
        int expected = 3; // 3 + 3 + 3
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }

    @Test
    public void testImpossibleTarget() {
        int[] coins = {2};
        int target = 3;
        int expected = -1; // not possible
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }

    @Test
    public void testZeroTarget() {
        int[] coins = {1, 2, 5};
        int target = 0;
        int expected = 0;
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }

    @Test
    public void testLargeTarget() {
        int[] coins = {1, 3, 4};
        int target = 10;
        int expected = 3; // 4 + 3 + 3
        assertEquals(expected, MinimumNumberOfCoins.getMinimumNumberOfCoins(coins, target));
    }
}
