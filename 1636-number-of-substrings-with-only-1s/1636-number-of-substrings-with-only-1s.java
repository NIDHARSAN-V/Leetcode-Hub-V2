class Solution {
    public int numSub(String s) {
        
        long res = 0;
        long count = 0;
        long mod = 1000000007;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1') {
                count++;
                res = (res + count) % mod;
            } else {
                count = 0;
            }
        }

        return (int)res;
    }
}
