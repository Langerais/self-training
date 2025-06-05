package length_of_common_prefix_after_rearrangement;

import java.util.*;

public class LengthOfCommonPrefixAfterRearrangement {

    public static int lengthOfCommonPrefixAfterRearrangement(String[] strings){
        if (strings == null || strings.length == 0) return 0;

        List<Map<Character,Integer>> maps = new ArrayList<>();
        Set<Character> uniqueChars  = new HashSet<>();

        for (String string : strings) {
            if (string == null) return 0;
            Map<Character, Integer> map = new HashMap<>();
            for (char c : string.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                uniqueChars .add(c);
            }
            maps.add(map);
        }

        int totalCommon = 0;
        for (char c : uniqueChars) {
            int minCount = Integer.MAX_VALUE;
            for (Map<Character, Integer> map : maps) {
                if (!map.containsKey(c)) {
                    minCount = 0;
                    break;
                }
                minCount = Math.min(minCount, map.get(c));
            }
            totalCommon += minCount;
        }

        return totalCommon;

    }

}
