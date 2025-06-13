package leetcode_75.kids_with_candies;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        ArrayList<Boolean> out = new ArrayList<>();
        int maxKid = 0;

        for(int candy : candies){
            if (candy > maxKid) maxKid = candy;
        }

        for (int candy : candies) {
            out.add(candy + extraCandies >= maxKid);
        }
        return out;

    }




}
