class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(1, x, n, 0L, dp); 
    }

    private int helper(int i, int x, int n, long target, int[][] dp) {
        if (target == n) {
            return 1; 
        }
        if (target > n || i > n) {
            return 0; 
        }
        if (dp[i][(int) target] != -1) { 
            return dp[i][(int) target];
        }

        long p = (long) Math.pow(i, x); 
        if (p > n - target) { 
            return dp[i][(int) target] = helper(i + 1, x, n, target, dp);
        }

     
        int include = helper(i + 1, x, n, target + p, dp) % MOD;
        int exclude = helper(i + 1, x, n, target, dp) % MOD;

        return dp[i][(int) target] = (include + exclude) % MOD;
    }
}
