class Solution {
    public boolean rotateString(String s, String goal) {
        // If the strings are of different lengths, they cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }
        
        // A rotated string will always be a substring of the original string concatenated with itself
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}