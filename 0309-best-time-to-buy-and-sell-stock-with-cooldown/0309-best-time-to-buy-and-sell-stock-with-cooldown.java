import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // Create a 2D dp array for memoization
        int[][] dp = new int[n][2]; // dp[i][0]: max profit at day i if not holding stock
                                    // dp[i][1]: max profit at day i if holding stock

        // Initialize dp array with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Call the recursive helper function
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int i, int holding, int[][] dp) {
        // Base case: If we reach the end of the array, profit is 0
        if (i >= prices.length) {
            return 0;
        }

        // If already computed, return the cached result
        if (dp[i][holding] != -1) {
            return dp[i][holding];
        }

        if (holding == 0) {
            // Case 1: Not holding stock, we can buy or skip
            dp[i][holding] = Math.max(
                helper(prices, i + 1, 0, dp),                // Skip buying
                -prices[i] + helper(prices, i + 1, 1, dp)   // Buy stock
            );
        } else {
            // Case 2: Holding stock, we can sell or skip
            dp[i][holding] = Math.max(
                helper(prices, i + 1, 1, dp),               // Skip selling
                prices[i] + helper(prices, i + 2, 0, dp)    // Sell stock
            );
        }

        return dp[i][holding];
    }

  
}
