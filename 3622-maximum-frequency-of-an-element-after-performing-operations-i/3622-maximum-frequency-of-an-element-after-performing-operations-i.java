class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Integer.MIN_VALUE;
        for(int i : nums)
        {
            max = Math.max(max  , i);
        }
        max = max + k  +1;
        int[] pre = new int[max];
        for(int i : nums)
        {
             pre[i]++;
        }

        for(int i = 1 ; i < max ; i++)
        {
            pre[i] += pre[i-1];
        }

        int ans = 0;

        for(int i = 0 ; i < max ; i++)
        {
            int lb = Math.max(0 , i-k);
            int ub = Math.min(i+k  , max-1);
            int total =  pre[ub] - (lb > 0 ? pre[lb-1] : 0);
            int freq = pre[i] - (i > 0 ? pre[i-1] : 0);

            ans = Math.max(ans , freq + Math.min(numOperations  , total-freq)); 
        }
        return ans;

    }
}