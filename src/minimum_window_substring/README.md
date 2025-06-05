# Minimum Window Substring

## Problem Description

Given two strings `s` and `t` of lengths `m` and `n` respectively, find the minimum window substring in `s` that contains **all characters** of `t` (including duplicates). If there is no such substring, return an empty string `""`.

The answer is guaranteed to be unique.

### Examples

- Input:  
  `s = "ADOBECODEBANC"`, `t = "ABC"`  
  Output: `"BANC"`  
  Explanation: The substring `"BANC"` contains `'A'`, `'B'`, and `'C'` and is the shortest such substring.

- Input:  
  `s = "a"`, `t = "a"`  
  Output: `"a"`  
  Explanation: The entire string is the minimum window.

- Input:  
  `s = "a"`, `t = "aa"`  
  Output: `""`  
  Explanation: The string `s` does not contain two `'a'` characters, so no valid window exists.

### Constraints

- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters.

---

## Approach

The solution uses a **sliding window** technique with two pointers and frequency counting arrays to efficiently find the minimum window substring containing all characters of `t`.

The general steps:

1. Use two arrays of length 128 (for ASCII) to store the frequency of characters needed from `t` and current window in `s`.
2. Expand the right pointer to include characters until the window satisfies all requirements.
3. Move the left pointer to shrink the window to find the smallest valid window.
4. Keep track of the minimum window found.
5. Return the substring of the minimum window.

This algorithm runs in **O(m + n)** time, where `m` and `n` are the lengths of `s` and `t`.

---

## Usage

Call the method `MinWindowSubstring.minWindow(s, t)` with your input strings.

Example:

```
String s = "ADOBECODEBANC";
String t = "ABC";
String result = MinWindowSubstring.minWindow(s, t);
System.out.println(result);  // Output: "BANC"
```