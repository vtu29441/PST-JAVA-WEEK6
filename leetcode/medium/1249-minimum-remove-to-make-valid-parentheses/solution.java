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