import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

    @Test
    public void testExample1() {
        int[] houses = {1, 2, 3, 1};
        assertEquals(4, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testExample2() {
        int[] houses = {2, 7, 9, 3, 1};
        assertEquals(12, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testSingleHouse() {
        int[] houses = {10};
        assertEquals(10, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testTwoHouses() {
        int[] houses = {5, 10};
        assertEquals(10, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testEmpty() {
        int[] houses = {};
        assertEquals(0, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testAllZeros() {
        int[] houses = {0, 0, 0, 0};
        assertEquals(0, HouseRobber.houseRobber(houses));
    }

    @Test
    public void testLargeValues() {
        int[] houses = {100, 200, 300, 400, 500};
        assertEquals(900, HouseRobber.houseRobber(houses));
    }
}
