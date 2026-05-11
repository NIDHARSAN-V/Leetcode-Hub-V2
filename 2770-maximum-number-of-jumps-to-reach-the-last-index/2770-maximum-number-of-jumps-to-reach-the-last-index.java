class Solution {

    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -100);
        return helper(0, nums, target , dp);
    }

    private int helper(int i, int[] nums, int target ,  int[] dp) {

        int n = nums.length;

        if (i == n - 1) {
            return 0;
        }

        if(dp[i]!=-100)
        {
            return dp[i];
        }
        
        int max = -1;
        for (int j = i + 1; j < n; j++) {

            if (Math.abs(nums[i] - nums[j]) <= target) {

                int res = helper(j, nums, target , dp);

                if (res != -1) {
                    max = Math.max(max, res + 1);
                }
            }
        }
        dp[i] = max;

        return max;
    }
}