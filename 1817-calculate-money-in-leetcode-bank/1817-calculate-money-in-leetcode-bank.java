class Solution {
    public int totalMoney(int n) {
        int weekStart = 1;  
        int res = 0;

        while (n > 0) {
            int days = Math.min(n, 7); 
            res += days * (2 * weekStart + (days - 1)) / 2;

            n -= 7;           
            weekStart++;      
        }

        return res;
    }
}
