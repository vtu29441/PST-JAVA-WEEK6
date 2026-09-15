# Minimum Remove to Make Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string s of `'('`, `')'` and lowercase English characters.

Your task is to remove the minimum number of parentheses (`'('` or `')'`, in any positions) so that the resulting  *parentheses string*  is valid and return  **any**  valid string.

Formally, a  *parentheses string*  is valid if and only if:

- It is the empty string, contains only lowercase characters, or
- It can be written as AB (A concatenated with B), where A and B are valid strings, or
- It can be written as (A), where A is a valid string.

 

 **Example 1:** 

```
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)", "lee(t(c)ode)" would also be accepted.

```

 **Example 2:** 

```
Input: s = "a)b(c)d"
Output: "ab(c)d"

```

 **Example 3:** 

```
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is either '(', ')', or lowercase English letter.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 82.78%)  
**Memory:** 46.9 MB (beats 90.90%)  
**Submitted:** 2026-09-15T08:48:42.759Z  

```java
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Identify invalid parentheses
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '*'; // Mark invalid closing parenthesis
                } else {
                    stack.pop();
                }
            }
        }
        
        // Step 2: Mark remaining unmatched opening parentheses
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }
        
        // Step 3: Build the final valid string
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)