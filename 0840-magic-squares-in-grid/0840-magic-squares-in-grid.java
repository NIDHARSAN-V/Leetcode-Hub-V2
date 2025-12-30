class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;

        if (r < 3 || c < 3) return 0;

        for (int i = 0; i <= r - 3; i++) {
            for (int j = 0; j <= c - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {

        
        if (g[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10];

       
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = g[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        int sum = g[r][c] + g[r][c + 1] + g[r][c + 2];

        
        for (int i = r; i < r + 3; i++) {
            if (g[i][c] + g[i][c + 1] + g[i][c + 2] != sum)
                return false;
        }

        
        for (int j = c; j < c + 3; j++) {
            if (g[r][j] + g[r + 1][j] + g[r + 2][j] != sum)
                return false;
        }

        
        if (g[r][c] + g[r + 1][c + 1] + g[r + 2][c + 2] != sum)
            return false;

        if (g[r][c + 2] + g[r + 1][c + 1] + g[r + 2][c] != sum)
            return false;

        return true;
    }
}
