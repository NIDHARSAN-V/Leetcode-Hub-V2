class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;       
        int n = grid[0].length;    
        int ans = Integer.MAX_VALUE;

        int minr = m, maxr = -1, minc = n, maxc = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minr = Math.min(minr, i);
                    maxr = Math.max(maxr, i);
                    minc = Math.min(minc, j);
                    maxc = Math.max(maxc, j);
                }
            }
        }

        if (maxr == -1) return 0;

        for (int i = minr; i < maxr - 1; i++) {
            for (int j = i + 1; j < maxr; j++) {
                int a = helper(grid, minr, i, minc, maxc);
                int b = helper(grid, i + 1, j, minc, maxc);
                int c = helper(grid, j + 1, maxr, minc, maxc);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        for (int j = minc; j < maxc - 1; j++) {
            for (int k = j + 1; k < maxc; k++) {
                int a = helper(grid, minr, maxr, minc, j);
                int b = helper(grid, minr, maxr, j + 1, k);
                int c = helper(grid, minr, maxr, k + 1, maxc);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        for (int i = minr; i < maxr; i++) {
            for (int j = minc; j < maxc; j++) {
                int a = helper(grid, minr, i, minc, maxc);
                int b = helper(grid, i + 1, maxr, minc, j);
                int c = helper(grid, i + 1, maxr, j + 1, maxc);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        for (int i = minr; i < maxr; i++) {
            for (int j = minc; j < maxc; j++) {
                int a = helper(grid, i + 1, maxr, minc, maxc);
                int b = helper(grid, minr, i, minc, j);
                int c = helper(grid, minr, i, j + 1, maxc);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        for (int j = minc; j < maxc; j++) {
            for (int i = minr; i < maxr; i++) {
                int a = helper(grid, minr, maxr, minc, j);
                int b = helper(grid, minr, i, j + 1, maxc);
                int c = helper(grid, i + 1, maxr, j + 1, maxc);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        for (int j = minc; j < maxc; j++) {
            for (int i = minr; i < maxr; i++) {
                int a = helper(grid, minr, maxr, j + 1, maxc);
                int b = helper(grid, minr, i, minc, j);
                int c = helper(grid, i + 1, maxr, minc, j);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        return ans;
    }

    private int helper(int[][] grid, int r1, int r2, int c1, int c2) {
        int minr = r2, maxr = r1, minc = c2, maxc = c1;
        boolean found = false;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    minr = Math.min(minr, i);
                    maxr = Math.max(maxr, i);
                    minc = Math.min(minc, j);
                    maxc = Math.max(maxc, j);
                }
            }
        }

        if (!found) return 0;
        return (maxr - minr + 1) * (maxc - minc + 1);
    }
}
