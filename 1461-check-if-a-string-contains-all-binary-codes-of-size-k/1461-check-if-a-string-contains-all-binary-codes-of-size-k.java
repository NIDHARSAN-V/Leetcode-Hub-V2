class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = 1<<k;
        boolean[] seen = new boolean[n];
        int num =0;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            num = (num<<1) & (n-1) | (s.charAt(i) -  '0');

            if (!seen[num] && (i >= k - 1))
            {
                seen[num] = true;
                ans++;
            }

            if(ans == n)
            {
                return true;
            }
        }

        return false;

        
    }
}