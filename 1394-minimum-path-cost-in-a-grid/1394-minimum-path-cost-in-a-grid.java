class Solution {
    public int minPathCost(int[][] grid, int[][] cost) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols]; // For memoization
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1 to indicate uncomputed values
        }
        
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < cols; col++) {
            ans = Math.min(ans, helper(grid, cost, 0, col, dp));
        }
        return ans;
    }

    private int helper(int[][] grid, int[][] cost, int row, int col, int[][] dp) {
        int rows = grid.length, cols = grid[0].length;

        // Base case: If we are at the last row, return the grid value at this cell
        if (row == rows - 1) {
            return grid[row][col];
        }

        // If the value is already computed, return it
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int minCost = Integer.MAX_VALUE;
        for (int nextCol = 0; nextCol < cols; nextCol++) {
            int currentCost = grid[row][col] + cost[grid[row][col]][nextCol] + helper(grid, cost, row + 1, nextCol, dp);
            minCost = Math.min(minCost, currentCost);
        }

        // Store the result in the dp array and return it
        dp[row][col] = minCost;
        return minCost;
    }
}
