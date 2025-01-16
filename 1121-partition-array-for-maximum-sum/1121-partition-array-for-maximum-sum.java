class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp , -1);
        return helper(arr , k , 0 , dp);
    }

    private int helper(int[] arr , int k , int s , int[]  dp)
    {
        if(s==arr.length)
        {
            return 0;
        }
        if(dp[s] != -1)
        {
            return dp[s];
        }
        int max_val =0;
        int max_sum =0;
        for(int i = s  ; i <Math.min(s+k , arr.length) ; i++ )
        {
            max_val = Math.max(arr[i] , max_val);
            int sum = max_val * (i - s + 1) + helper(arr , k , i + 1 ,dp);
            max_sum = Math.max(sum  , max_sum);
        }
        dp[s] = max_sum;
        return dp[s];
    
    }
}