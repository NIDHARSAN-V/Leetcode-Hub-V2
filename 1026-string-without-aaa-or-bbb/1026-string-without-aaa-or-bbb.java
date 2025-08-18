class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > 0 || b > 0) {
            int n = sb.length();
            
            if (n >= 2 && sb.charAt(n-1) == sb.charAt(n-2)) {
            
                if (sb.charAt(n-1) == 'a') {
                    sb.append('b');
                    b--;
                } else {
                    sb.append('a');
                    a--;
                }
            } else {
             
                if (a >= b) {
                    sb.append('a');
                    a--;
                } else {
                    sb.append('b');
                    b--;
                }
            }
        }
        return sb.toString();
    }
}
