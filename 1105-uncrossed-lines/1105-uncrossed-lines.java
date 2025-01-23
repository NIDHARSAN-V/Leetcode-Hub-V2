class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] d : dp)
        {
            Arrays.fill(d , -1);
        }
        return helper(nums1 , nums2 , 0 , 0 ,dp);
    }

    private int helper(int[] nums1 , int[] nums2 ,  int i , int j,int[][] dp)
    {
        if(i==nums1.length || j==nums2.length)
        {
            return 0;
        }

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
       
        if(nums1[i]==nums2[j])
        {
            dp[i][j]  = 1 + helper(nums1 , nums2 , i+1 , j+1 , dp);
        }
        else
        {
            dp[i][j] = Math.max( helper(nums1 , nums2 , i , j+1 , dp)  ,  helper(nums1 , nums2 , i+1 , j , dp));
        }
        return dp[i][j];
    }
}