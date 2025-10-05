import java.util.*;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 4 directions

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] p_vis = new boolean[r][c];
        boolean[][] a_vis = new boolean[r][c];

        // Run DFS from each cell
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                dfs(heights, i, j, p_vis, a_vis, r, c, heights[i][j]);
            }
        }

        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(p_vis[i][j] && a_vis[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    // DFS returns boolean[2] -> [pacificReachable, atlanticReachable]
    private boolean[] dfs(int[][] heights, int i, int j, boolean[][] p_vis, boolean[][] a_vis, int r, int c, int prevHeight){
        // Boundary check
        if(i < 0 || i >= r || j < 0 || j >= c) return new boolean[]{false, false};
        // Height check
        if(heights[i][j] < prevHeight) return new boolean[]{false, false};

        // Already visited by both oceans
        if(p_vis[i][j] && a_vis[i][j]) return new boolean[]{true, true};

        boolean pac = p_vis[i][j];
        boolean atl = a_vis[i][j];

        // Check if current cell is on Pacific border
        if(i == 0 || j == 0) pac = true;
        // Check if current cell is on Atlantic border
        if(i == r - 1 || j == c - 1) atl = true;

        // Explore 4 directions, only if neighbor >= current cell height
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni < 0 || ni >= r || nj < 0 || nj >= c) continue;
            if(heights[ni][nj] >= heights[i][j]){
                boolean[] res = dfs(heights, ni, nj, p_vis, a_vis, r, c, heights[i][j]);
                pac = pac || res[0];
                atl = atl || res[1];
            }
        }

        // Mark visited
        if(pac) p_vis[i][j] = true;
        if(atl) a_vis[i][j] = true;

        return new boolean[]{pac, atl};
    }
}
