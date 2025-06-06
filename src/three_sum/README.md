# ThreeSum Problem

## Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`, `i != k`, and `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

**Notice:** The solution set must **not** contain duplicate triplets.

---

## Examples

### Example 1

Input:  
`nums = [-1, 0, 1, 2, -1, -4]`

Output:  
`[[-1, -1, 2], [-1, 0, 1]]`

Explanation:
- `nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0`
- `nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0`
- `nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0`

The distinct triplets are `[-1, 0, 1]` and `[-1, -1, 2]`.  
*Note:* The order of output and order of triplets does not matter.

---

### Example 2

Input:  
`nums = [0, 1, 1]`

Output:  
`[]`

Explanation: The only possible triplet does not sum up to 0.

---

### Example 3

Input:  
`nums = [0, 0, 0]`

Output:  
`[[0, 0, 0]]`

Explanation: The only possible triplet sums up to 0.

---

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

---

## Implementation

The algorithm sorts the array and uses a three-pointer technique to find all unique triplets summing to zero efficiently, skipping duplicates to avoid repeated triplets.

---

## How to run

- Compile and run the `ThreeSum` class which contains the method `threeSum` and example tests in the `main` method.
- Alternatively, run the JUnit tests provided in `ThreeSumTest` for automated verification of functionality.
