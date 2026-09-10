# Circular Palindromes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A *palindrome* is a string that reads the same from left to right as it does from right to left.

Given a string, $S$, of $N$ lowercase English letters, we define a *$k$-length rotation* as cutting the first $k$ characters from the beginning of $S$ and appending them to the end of $S$. For each $S$, there are $N$ possible $k$-length rotations (where $0 \le k \lt N$). See the *Explanation* section for examples.

Given $N$ and $S$, find all $N$ $k$-length rotations of $S$; for each rotated string, $S_k$, print the maximum possible length of any palindromic substring of $S_k$ on a new line.

**Input Format**

The first line contains an integer, $N$ (the length of $S$).	
The second line contains a single string, $S$.

**Constraints**

- $1 \le N \le 5 \times 10^5$
- $0 \le k \lt N$
- $\textit{S is comprised of lowercase English letters.}$

**Output Format**

There should be $N$ lines of output, where each line $k$ contains an integer denoting the maximum length of any palindromic substring of rotation $S_k$.

**Sample Input 0**

    13
    aaaaabbbbaaaa
    
**Sample Output 0**

    12
    12
    10
    8
    8
    9
    11
    13
    11
    9
    8
    8
    10

**Sample Input 1**

    7
    cacbbba
    
**Sample Output 1**

    3
    3
    3
    3
    3
    3
    3


**Sample Input 2**

    12
    eededdeedede

**Sample Output 2**

    5
    7
    7
    7
    7
    9
    9
    9
    9
    7
    5
    4

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:44:04.366Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;

            do {
                c = read();
            } while (c <= ' ');

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class MaxHeap {
        int[] heap;
        int[] map;
        int[] pos;
        int size;

        MaxHeap(int n) {
            heap = new int[n + 5];
            map = new int[n + 5];
            pos = new int[n + 5];
            Arrays.fill(pos, -1);
            size = 0;
        }

        void add(int id, int value) {
            if (pos[id] != -1) return;

            size++;
            heap[size] = value;
            map[size] = id;
            pos[id] = size;
            up(size);
        }

        void remove(int id) {
            int p = pos[id];

            if (p == -1) return;

            int lastId = map[size];
            int lastValue = heap[size];

            pos[id] = -1;
            size--;

            if (p <= size) {
                map[p] = lastId;
                heap[p] = lastValue;
                pos[lastId] = p;

                up(p);
                down(p);
            }
        }

        int max() {
            return size == 0 ? Integer.MIN_VALUE : heap[1];
        }

        int size() {
            return size;
        }

        void up(int i) {
            while (i > 1) {
                int p = i >> 1;

                if (heap[p] >= heap[i])
                    break;

                swap(p, i);
                i = p;
            }
        }

        void down(int i) {
            while (true) {
                int left = i << 1;

                if (left > size)
                    break;

                int right = left + 1;
                int best = left;

                if (right <= size && heap[right] > heap[left])
                    best = right;

                if (heap[i] >= heap[best])
                    break;

                swap(i, best);
                i = best;
            }
        }

        void swap(int a, int b) {
            int tv = heap[a];
            heap[a] = heap[b];
            heap[b] = tv;

            int ti = map[a];
            map[a] = map[b];
            map[b] = ti;

            pos[map[a]] = a;
            pos[map[b]] = b;
        }
    }

    static int[] palindrome(char[] s) {
        int n = s.length;
        int[] r = new int[2 * n];

        int k = 0;

        for (int i = 0, j = 0; i < 2 * n; i += k) {

            if (j < 0)
                j = 0;

            while (i - j >= 0 &&
                   i + j + 1 < 2 * n &&
                   s[(i - j) / 2] == s[(i + j + 1) / 2]) {
                j++;
            }

            r[i] = j;

            k = 1;

            while (i - k >= 0 &&
                   r[i] - k >= 0 &&
                   r[i - k] != r[i] - k) {

                r[i + k] = Math.min(r[i - k], r[i] - k);
                k++;
            }

            j = Math.max(j - k, 0);
        }

        return r;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        String str = fs.next();

        char[] s = new char[2 * n];

        for (int i = 0; i < n; i++) {
            s[i] = str.charAt(i);
            s[i + n] = str.charAt(i);
        }

        int[] pal = palindrome(s);

        long[] events = new long[16 * n];
        int eventCount = 0;

        // Even centers
        for (int i = 0; i < 4 * n; i += 2) {

            pal[i] = Math.min(
                    pal[i],
                    n - ((n & 1) ^ 1)
            );

            events[eventCount++] =
                    ((long) (i / 2) << 32) | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n - pal[i] / 2 - 1) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n) << 32)
                    | (i & 0xffffffffL);
        }

        // Odd centers
        for (int i = 1; i < 4 * n; i += 2) {

            pal[i] = Math.min(
                    pal[i],
                    n - (n & 1)
            );

            events[eventCount++] =
                    ((long) (i / 2) << 32) | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n - pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n) << 32)
                    | (i & 0xffffffffL);
        }

        Arrays.sort(events, 0, eventCount);

        MaxHeap inc = new MaxHeap(4 * n + 5);
        MaxHeap dec = new MaxHeap(4 * n + 5);
        MaxHeap flat = new MaxHeap(4 * n + 5);

        int[] state = new int[4 * n];

        int q = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 2 * n - 1; i++) {

            while (q < eventCount &&
                   (events[q] >>> 32) <= i) {

                int ind = (int) events[q];

                if (state[ind] == 0) {

                    inc.add(
                            ind,
                            (pal[ind] & 1) - 2 * i
                    );

                } else if (state[ind] == 1) {

                    inc.remove(ind);

                    flat.add(
                            ind,
                            pal[ind]
                    );

                } else if (state[ind] == 2) {

                    flat.remove(ind);

                    dec.add(
                            ind,
                            pal[ind] + 2 * i
                    );

                } else if (state[ind] == 3) {

                    dec.remove(ind);
                }

                state[ind]++;
                q++;
            }

            if (i >= n - 1) {

                int answer = 0;

                if (inc.size() > 0) {
                    answer = Math.max(
                            answer,
                            inc.max() + 2 * i
                    );
                }

                if (dec.size() > 0) {
                    answer = Math.max(
                            answer,
                            dec.max() - 2 * i
                    );
                }

                if (flat.size() > 0) {
                    answer = Math.max(
                            answer,
                            flat.max()
                    );
                }

                output.append(answer).append('\n');
            }
        }

        System.out.print(output);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/circular-palindromes/problem)