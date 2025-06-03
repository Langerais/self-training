# Product Of Array Excluding Self

## Problem Description

Given an array of integers, return a new array such that each element at index `i` of the new array is the product of all the numbers in the original array except the one at `i`.

- For example, if the input is `[1, 2, 3, 4, 5]`, the expected output is `[120, 60, 40, 30, 24]`.
- If the input is `[3, 2, 1]`, the expected output is `[2, 3, 6]`.

### Follow-up

What if you can't use division?

---

## Requirements & Notes

- The output array should be the same length as the input.
- The solution must handle zeros correctly.
- Efficiency: an O(n) time complexity and O(n) space complexity solution is expected.
- Works for arrays of length 1 or more.

---

## Approach

1. Create two auxiliary arrays:
  - `prefix[i]` stores the product of all elements before index `i`.
  - `suffix[i]` stores the product of all elements after index `i`.
2. Calculate prefix products from left to right.
3. Calculate suffix products from right to left.
4. The output at index `i` is the product of `prefix[i]` and `suffix[i]`.
5. Return the resulting array.

---

## Running the Program

Compile and run the program with:

```bash
javac ProductOfArrayExcl.java
java ProductOfArrayExcl
```

---

## Example Test Cases

- Input: `[1, 2, 3, 4]`  
  Output: `[24, 12, 8, 6]`


- Input: `[1, 2, 0, 4]`
  Output: `[0, 0, 8, 0]`


- Input: `[0, 2, 0, 4]`  
  Output: `[0, 0, 0, 0]`


- Input: `[1, 1, 1, 1]`  
  Output: `[1, 1, 1, 1]`


- Input: `[5]` - *For a single-element input, the output is [1] because the product of all other elements (none) is considered 1 by definition.*

  Output: `[1]`


- Input: `[3, 7]`  
  Output: `[7, 3]`

---

## Testing

JUnit tests are provided in a separate file within the same folder.


