# Rotate String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `goal`, return `true`  *if and only if*  `s`  *can become*  `goal`  *after some number of  **shifts**  on*  `s`.

A  **shift**  on `s` consists of moving the leftmost character of `s` to the rightmost position.

- For example, if s = "abcde", then it will be "bcdea" after one shift.

 

 **Example 1:** 

```
Input: s = "abcde", goal = "cdeab"
Output: true

```

 **Example 2:** 

```
Input: s = "abcde", goal = "abced"
Output: false

```

 

 **Constraints:** 

- 1 <= s.length, goal.length <= 100
- s and goal consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 63.84%)  
**Memory:** 43.4 MB (beats 67.23%)  
**Submitted:** 2026-09-10T06:23:06.190Z  

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        // If the strings are of different lengths, they cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }
        
        // A rotated string will always be a substring of the original string concatenated with itself
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotate-string/)