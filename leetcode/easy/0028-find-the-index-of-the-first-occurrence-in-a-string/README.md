# Find the Index of the First Occurrence in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

 

 **Example 1:** 

```
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

```

 **Example 2:** 

```
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

```

 

 **Constraints:** 

- 1 <= haystack.length, needle.length <= 104
- haystack and needle consist of only lowercase English characters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 49.65%)  
**Memory:** 42.8 MB (beats 91.38%)  
**Submitted:** 2026-09-10T06:33:01.153Z  

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        // If needle is longer than haystack, it can't be found
        if (n > m) return -1;
        
        // Loop through the haystack
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            // Check if the characters match the needle
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we've matched all characters in the needle, return the starting index
            if (j == n) {
                return i;
            }
        }
        
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)