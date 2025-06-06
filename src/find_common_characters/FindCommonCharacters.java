package find_common_characters;

import java.util.*;

public class FindCommonCharacters {

    public static void main(String[] args) {

        String [] in = {"bella","label","roller"};
        List<String> out = commonChars(in);
        System.out.println(out.toString());


    }


    public static List<String> commonChars(String[] words) {

        List<String> out = new ArrayList<>();
        int[][] set = new int[words.length][26];

        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()){
                set[i][c - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            int minCount = Integer.MAX_VALUE;
            for(int j = 0; j < words.length; j++){
                minCount = Math.min(minCount, set[j][i]);
            }

            for (int j = 0; j < minCount; j++) {
                out.add(String.valueOf((char) (i + 'a')));
            }

        }


        return out;
    }



}
