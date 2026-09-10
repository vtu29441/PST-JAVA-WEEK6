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
