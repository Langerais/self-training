package leetcode_75.reverse_vowels;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {


    public String reverseVowels(String s) {
        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !isVowel[chars[left]]) left++;
            while (left < right && !isVowel[chars[right]]) right--;

            if (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }

        return new String(chars);
    }



}
