class Solution {
    public int totalMoney(int n) {
        int ini = 1;   
        int i_i = ini; 
        int res = 0;
        int i = 0;   

        while (n != 0) {
            res += ini;
            ini++;
            i++;
            n--;

        
            if (i % 7 == 0) {
                i_i++;
                ini = i_i;
            }
        }

        return res;
    }
}
