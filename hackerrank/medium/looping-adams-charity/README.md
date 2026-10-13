# Looping - Adam’s Charity

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Adam decides to be generous and do some charity. Starting today, from day 1 until day n, he gives i2 coins to charity on day ‘i’ (1 <= i <= n).

Return the total coins he would give to charity.

 **Input Format** 

Input consists of one integer

 **Constraints** 

NA

 **Output Format** 

Output consists of one integer

 **Sample Input 0** 

```
2

```

 **Sample Output 0** 

```
5

```

 **Explanation 0** 

- There are 2 days.
- On the first day, he will give 1^2 = 1 coin.
- On the second day, he will give 2^2 = 4.
- Total no.of coins = 1 + 4 = 5

 **Sample Input 1** 

```
5

```

 **Sample Output 1** 

```
55

```

 **Explanation 1** 

- There are 5 days.
- On the first day, he will give 1^1 = 1 coin.
- On the second day, he will give 2^2 = 4 coins and therefore 9, 16 and 25 respectively on 3rd, 4th, 5th day.
- Total no of coins = 1 + 4 + 9 + 16 + 25 = 55

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-13T04:34:44.031Z  

```java
import java.io.*;
import java.util.*;

public class Solution {
public static void main(String[] arg){
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextInt()){
        int n = scanner.nextInt();
        long totalCoins =0;
        for (int i=1; i <= n; i++){
            totalCoins += (long) i * i;
        }
        System.out.println(totalCoins);
    }
    scanner.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/looping-adams-charity/problem)