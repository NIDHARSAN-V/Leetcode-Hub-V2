class Solution {
    int rows, cols;
    int[][][] dir = {
        {},
        {{0, -1}, {0, 1}},   // 1
        {{-1, 0}, {1, 0}},   // 2
        {{0, -1}, {1, 0}},   // 3
        {{0, 1}, {1, 0}},    // 4
        {{0, -1}, {-1, 0}},  // 5
        {{0, 1}, {-1, 0}}    // 6
    };

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row == rows - 1 && col == cols - 1) return true;

        visited[row][col] = true;

        for (int[] d : dir[grid[row][col]]) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) {
                continue;
            }

       
            for (int[] back : dir[grid[newRow][newCol]]) {
                if (newRow + back[0] == row && newCol + back[1] == col) {
                    if (dfs(grid, newRow, newCol, visited)) return true;
                }
            }
        }
        return false;
    }
}