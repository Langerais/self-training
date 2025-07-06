package leetcode_75.decode_string;

/**
 * 394. Decode String
 * Medium
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */

public class DecodeString {

    //TODO: REVISIT
    
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[sd]"));
    }

    int pos = 0; // instance variable

    public String decodeString(String s) {
        pos = 0; // reset position before decoding
        return decode(s);
    }

    public String decode(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        while (pos < n && s.charAt(pos) != ']') {
            char c = s.charAt(pos);

            if (Character.isDigit(c)) {
                int k = 0;
                while (pos < n && Character.isDigit(s.charAt(pos))) {
                    k = k * 10 + (s.charAt(pos) - '0');
                    pos++;
                }

                pos++; // skip '['
                String decoded = decode(s);
                pos++; // skip ']'

                for (int i = 0; i < k; i++) {
                    result.append(decoded);
                }
            } else {
                result.append(c);
                pos++;
            }
        }

        return result.toString();
    }
}
