package leetcode_75.max_vowels_in_substring;


/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Medium
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */


public class MaxVowelsInSubstring {

    public int maxVowels(String s, int k) {

        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        char[] arr = s.toCharArray();
        int curr = 0, max = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel[arr[i] - 'a']) curr++;
        }
        max = curr;

        for (int i = k; i < arr.length; i++) {
            curr += isVowel[arr[i]     - 'a'] ? 1 : 0;
            curr -= isVowel[arr[i - k] - 'a'] ? 1 : 0;
            if (curr > max) max = curr;
        }

        return max;
    }

}
