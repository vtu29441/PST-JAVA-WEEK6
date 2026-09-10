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