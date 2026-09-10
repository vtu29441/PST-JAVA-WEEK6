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