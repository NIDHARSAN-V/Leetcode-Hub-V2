class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        pq.add(new int[]{grid[0][0], 0, 0});
        int ans = -1;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], x = cur[1], y = cur[2];
            
            ans = Math.max(ans, h);
            
            if (x == n - 1 && y == n - 1)
                return ans;
            
            if (vis[x][y])
                continue;
            
            vis[x][y] = true;
            
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !vis[nx][ny]) {
                    pq.add(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        
        return -1; 
    }
}
