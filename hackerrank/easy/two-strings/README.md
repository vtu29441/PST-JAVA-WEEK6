# Two Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings, determine if they share a common substring.  A substring may be as small as one character.  

**Example**   
$s1 = \text{'and'}$  
$s2 = \text{'art'}$  

These share the common substring $a$.  

$s1 = \text{'be'}$  
$s2 = \text{'cat'}$  

These do not share a substring.  

**Function Description**

Complete the function *twoStrings* in the editor below.    

twoStrings has the following parameter(s):  

- *string s1:*  a string
- *string s2:*  another string    

**Returns**  

- *string:* either `YES` or `NO`

**Input Format**

The first line contains a single integer $p$, the number of test cases.		

The following $p$ pairs of lines are as follows:

- The first line contains string $s1$.
- The second line contains string $s2$.

**Constraints**

- $s1$ and $s2$ consist of characters in the range ascii[a-z].
- $1 \le p \le 10$
- $1 \le |s1|, |s2| \le 10^5$

**Output Format**

For each pair of strings, return `YES` or `NO`.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:51:30.543Z  

```java
import java.util.*;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        boolean[] letters = new boolean[26];

        for (char c : s1.toCharArray()) {
            letters[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (letters[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(twoStrings(s1, s2));
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/two-strings/problem)