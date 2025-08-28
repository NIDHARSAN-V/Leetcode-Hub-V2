class Solution {
    public int[][] diagonalSort(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        
        for (int i = 0; i < m; i++) {
            sorthelper(grid, i, 0);
        }

       
        for (int j = 1; j < n; j++) {
            sorthelper(grid, 0, j);
        }

        return grid;
    }

    private void sorthelper(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> diag = new ArrayList<>();

        
        for (int i = r, j = c; i < m && j < n; i++, j++) {
            diag.add(grid[i][j]);
        }

       
        Collections.sort(diag);

        
        int idx = 0;
        for (int i = r, j = c; i < m && j < n; i++, j++) {
            grid[i][j] = diag.get(idx++);
        }
    }
}
