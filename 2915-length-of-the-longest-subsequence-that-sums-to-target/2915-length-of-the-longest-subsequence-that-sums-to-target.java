class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[][] dp = new int[target + 1][nums.size()];
        
        for (int s = 0; s <= target; s++) {
            Arrays.fill(dp[s], -2);
        }

        return Math.max(-1, helper(nums, target, 0, 0, dp));
    }

    private int helper(List<Integer> nums, int target, int i, int sum, int[][] dp) {

        if (sum == target) return 0;
        if (i == nums.size() || sum > target) return -1;

        if (dp[sum][i] != -2) return dp[sum][i];

        //inc
        int inc = helper(nums, target, i + 1, sum + nums.get(i), dp);
        if (inc != -1) inc = inc + 1;

        //exc
        int exc = helper(nums, target, i + 1, sum, dp);

        dp[sum][i] = Math.max(inc, exc);
        return dp[sum][i];
    }
}
