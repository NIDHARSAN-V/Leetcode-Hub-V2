class Solution {
    public int myAtoi(String ss) {
        String s = ss.trim();
        
        if (s.isEmpty()) {
            return 0;
        }
        
        // Determine the sign
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        }
        
        int res = 0;
        
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If the character is not a digit, return the result
            if (!Character.isDigit(ch)) {
                break;
            }
            
            // Convert the character to a digit
            int digit = ch - '0';
            
            // Handle overflow by checking if the result is out of the 32-bit signed integer range
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Update result
            res = res * 10 + digit;
        }
        
        return res * sign;
    }
}
