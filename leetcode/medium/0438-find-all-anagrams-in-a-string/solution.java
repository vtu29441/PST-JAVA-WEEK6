import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // If s is shorter than p, it's impossible to find an anagram
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Populate the frequency array for string p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        // Populate the frequency array for the first window in string s
        for (int i = 0; i < windowSize; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the first window is an anagram
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window across the rest of string s
        for (int i = windowSize; i < s.length(); i++) {
            // Add the new character entering the window
            sCount[s.charAt(i) - 'a']++;
            
            // Remove the old character leaving the window
            sCount[s.charAt(i - windowSize) - 'a']--;

            // Compare the frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}