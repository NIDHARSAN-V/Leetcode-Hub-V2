class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        return helper(triangle, dp, 0, 0);
    }

    private int helper(List<List<Integer>> tri, int[][] dp, int row, int col) {

        if (row == tri.size()) {
            return 0;
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

 
        dp[row][col] = tri.get(row).get(col) 
            + Math.min(helper(tri, dp, row + 1, col), helper(tri, dp, row + 1, col + 1));

        return dp[row][col];
    }
}
