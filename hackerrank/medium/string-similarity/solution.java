import java.io.*;
import java.util.*;

public class Solution {

    static long stringSimilarity(String s) {
        int n = s.length();
        int[] z = new int[n];

        z[0] = n;
        int left = 0, right = 0;
        long answer = n;

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }

            answer += z[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(stringSimilarity(s));
        }

        sc.close();
    }
}
