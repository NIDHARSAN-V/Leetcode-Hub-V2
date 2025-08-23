class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;       
        int n = grid[0].length;    
        int ans = Integer.MAX_VALUE;

        // 1. horizontal split into 3 parts
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                int a = helper(grid, 0, i, 0, n - 1);
                int b = helper(grid, i + 1, j, 0, n - 1);
                int c = helper(grid, j + 1, m - 1, 0, n - 1);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        // 2. vertical split into 3 parts
        for (int j = 0; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                int a = helper(grid, 0, m - 1, 0, j);
                int b = helper(grid, 0, m - 1, j + 1, k);
                int c = helper(grid, 0, m - 1, k + 1, n - 1);
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        // 3. top horizontal + bottom vertical split
        for (int i = 0; i < m - 1; i++) {       // row cut
            for (int j = 0; j < n - 1; j++) {   // col cut
                int a = helper(grid, 0, i, 0, n - 1);        
                int b = helper(grid, i + 1, m - 1, 0, j);    
                int c = helper(grid, i + 1, m - 1, j + 1, n - 1); 
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        // 4. bottom horizontal + top vertical split
        for (int i = 0; i < m - 1; i++) {       // row cut
            for (int j = 0; j < n - 1; j++) {   // col cut
                int a = helper(grid, i + 1, m - 1, 0, n - 1); 
                int b = helper(grid, 0, i, 0, j);             
                int c = helper(grid, 0, i, j + 1, n - 1);     
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        // 5. left vertical + right horizontal split
        for (int j = 0; j < n - 1; j++) {       // col cut
            for (int i = 0; i < m - 1; i++) {   // row cut
                int a = helper(grid, 0, m - 1, 0, j);         
                int b = helper(grid, 0, i, j + 1, n - 1);     
                int c = helper(grid, i + 1, m - 1, j + 1, n - 1); 
                if (a > 0 && b > 0 && c > 0)
                    ans = Math.min(ans, a + b + c);
            }
        }

        // 6. right vertical + left horizontal split
        for (int j = 0; j < n - 1; j++) {       // col cut
            for (int i = 0; i < m - 1; i++) {   // row cut
                int a = helper(grid, 0, m - 1, j + 1, n - 1); 
                int b = helper(grid, 0, i, 0, j);             
                int c = helper(grid, i + 1, m - 1, 0, j);    
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
