# Repeated Substring Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s`, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

 **Example 1:** 

```
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

```

 **Example 2:** 

```
Input: s = "aba"
Output: false

```

 **Example 3:** 

```
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

```

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 71.87%)  
**Memory:** 47 MB (beats 32.62%)  
**Submitted:** 2026-09-10T06:17:01.014Z  

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // The maximum length of a repeating substring is half of the string's length
        for (int i = n / 2; i >= 1; i--) {
            // The repeating substring length must cleanly divide the string's total length
            if (n % i == 0) {
                int numRepeats = n / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < numRepeats; j++) {
                    sb.append(sub);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/repeated-substring-pattern/)