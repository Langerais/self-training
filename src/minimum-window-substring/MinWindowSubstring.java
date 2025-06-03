import java.util.Arrays;
import java.util.HashMap;

public class MinWindowSubstring {

    public static void main(String[] args) {
        runTest("ADOBECODEBANC", "ABC", "BANC");
        runTest("a", "a", "a");
        runTest("a", "aa", "");
        runTest("ab", "b", "b");
        runTest("aaflslflsldkalskaaa", "aaa", "aaa");
        runTest("xyz", "z", "z");
        runTest("xyz", "w", "");
    }

    private static void runTest(String s, String t, String expected) {
        String result = minWindow(s, t);
        if (result.equals(expected)) {
            System.out.printf("PASS: minWindow(\"%s\", \"%s\") = \"%s\"\n", s, t, result);
        } else {
            System.out.printf("FAIL: minWindow(\"%s\", \"%s\") = \"%s\", expected \"%s\"\n", s, t, result, expected);
        }
    }


    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        // Count frequency of chars in t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;  // Number of unique chars in t that must be present
        for (int count : need) {
            if (count > 0) required++;
        }

        int formed = 0;    // Number of unique chars that currently meet required frequency
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;

            // If current char meets the required count, increment formed
            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }

            // Try to shrink the window when all required chars are formed
            while (formed == required) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Remove char at left and update window and formed accordingly
                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}



