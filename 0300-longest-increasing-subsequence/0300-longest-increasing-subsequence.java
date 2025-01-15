class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] d : dp)
        {
            Arrays.fill(d ,-1);
        }
        return helper(nums , 0 , -1 ,dp);

    }
    private int helper(int[] nums , int i , int prev , int[][] dp)
    {
        if(i==nums.length)
        {
            return 0;
        }

        if(dp[i][prev + 1]!=-1)
        { 
           return dp[i][prev+1];
        }

        dp[i][prev+1] = 0 +  helper(nums , i + 1 , prev , dp);
        if(prev == -1 || nums[i] > nums[prev])
        {
        dp[i][prev+1]= Math.max(dp[i][prev+1] , 1 + helper(nums , i + 1 , i , dp));
        }
        return dp[i][prev+1];
    }
}
