class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int[][] arr : dp) {
            for (int[] subArr : arr) {
                Arrays.fill(subArr, -1); 
            }
        }
        return helper(strs, m, n, 0, dp);
    }

    private int helper(String[] strs, int m, int n, int index, int[][][] dp) {
        if (index == strs.length) {
            return 0;
        }
        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }
        int currZeros = counter(strs[index], '0');
        int currOnes = counter(strs[index], '1');
        int exclude = helper(strs, m, n, index + 1, dp); 
        int include = 0;
        if (m >= currZeros && n >= currOnes) {
            include = 1 + helper(strs, m - currZeros, n - currOnes, index + 1, dp);
        } 
        return dp[index][m][n] = Math.max(include, exclude);
    }

    private int counter(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}
