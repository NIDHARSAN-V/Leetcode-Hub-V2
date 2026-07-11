class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] pre = new int[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int up = (i > 0) ? pre[i - 1][j] : 0;
                int left = (j > 0) ? pre[i][j - 1] : 0;
                int diagonal = (i > 0 && j > 0) ? pre[i - 1][j - 1] : 0;

                pre[i][j] = grid[i][j] + up + left - diagonal;

                if (pre[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}