class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 0; i < m; i++) {
            sorthelper(grid, i, 0, false); 
        }

        
        for (int j = 1; j < n; j++) {
            sorthelper(grid, 0, j, true); 
        }

        return grid;
    }

    private void sorthelper(int[][] grid, int r, int c, boolean asc) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = r, j = c; i < m - 1 && j < n - 1; i++, j++) {
            for (int ii = i + 1, jj = j + 1; ii < m && jj < n; ii++, jj++) {
                if (asc) {
                    
                    if (grid[i][j] > grid[ii][jj]) {
                        int temp = grid[i][j];
                        grid[i][j] = grid[ii][jj];
                        grid[ii][jj] = temp;
                    }
                } else {
                
                    if (grid[i][j] < grid[ii][jj]) {
                        int temp = grid[i][j];
                        grid[i][j] = grid[ii][jj];
                        grid[ii][jj] = temp;
                    }
                }
            }
        }
    }
}
