class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int[][][] dp  = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Call the helper function
        return helper(prices, 0, 0, 2, dp);



    }
    private int helper(int[] prices , int i , int buy , int maxc,int[][][] dp)
    {
        if(i==prices.length || maxc==0)
        {
            return 0;
        }
        if(dp[i][buy][maxc]!=-1)
        {
            return dp[i][buy][maxc];
        }
        dp[i][buy][maxc] = 0;
        if(buy==0)
        {
            dp[i][buy][maxc] = Math.max(0 + helper(prices , i+1 , 0 , maxc ,dp) , -prices[i] + helper(prices , i+1 , 1 , maxc,dp));
        }
        else
        {
            dp[i][buy][maxc] = Math.max(0 + helper(prices , i+1 , 1 , maxc ,dp) , prices[i] + helper(prices , i+1 , 0 , maxc -1 , dp));
        }

        return dp[i][buy][maxc];
    }
}