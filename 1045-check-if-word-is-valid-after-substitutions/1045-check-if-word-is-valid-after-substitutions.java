

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push the current character onto the stack
            stack.push(c);
            
            // Check the top 3 elements of the stack for "abc"
            if (stack.size() >= 3) {
                char third = stack.pop(); // Pop the top character
                char second = stack.pop(); // Pop the second character
                char first = stack.pop(); // Pop the third character
                
                // If the sequence is not "abc", push them back
                if (first != 'a' || second != 'b' || third != 'c') {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                }
            }
        }
        
        // If the stack is empty, the string is valid
        return stack.isEmpty();
    }
}
