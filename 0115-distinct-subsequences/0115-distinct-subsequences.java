class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1
        }
        return helper(s, t, 0, 0, dp);
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) {
            return 1; // Found a valid subsequence
        }
        if (i == s.length()) {
            return 0; // `s` is exhausted, no more subsequences possible
        }
        if (dp[i][j] != -1) {
            return dp[i][j]; // Return the memoized result
        }

        // Calculate the number of subsequences
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += helper(s, t, i + 1, j + 1, dp); // Include the current character
        }
        result += helper(s, t, i + 1, j, dp); // Skip the current character in `s`

        dp[i][j] = result; // Memoize the result
        return result;
    }
}
