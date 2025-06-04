public class HouseRobber {
        public static int houseRobber(int[] houses){

        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int prevPrev = houses[0];
        int prev = Math.max(houses[0], houses[1]);
        int curr = prev;

        for (int i = 2; i < houses.length; i++) {
            curr = Math.max(prevPrev + houses[i], prev);
            prevPrev = prev;
            prev = curr;
        }

        return curr;
    }
}
