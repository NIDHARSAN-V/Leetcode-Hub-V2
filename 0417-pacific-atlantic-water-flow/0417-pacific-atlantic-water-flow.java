class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] p_vis = new boolean[r][c];
        boolean[][] a_vis = new boolean[r][c];

        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                dfs(heights, i, j, p_vis, a_vis, heights[i][j]);
            }
        }

        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(p_vis[i][j] && a_vis[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    
    private void dfs(int[][] heights, int i, int j, boolean[][] p_vis, boolean[][] a_vis, int prevHeight) {
        int r = heights.length;
        int c = heights[0].length;

       
        if(i < 0 || i >= r || j < 0 || j >= c) return;

        
        if(p_vis[i][j] && a_vis[i][j]) return;

        
        if(heights[i][j] < prevHeight) return;

     
        if(i == 0 || j == 0) p_vis[i][j] = true;

        if(i == r-1 || j == c-1) a_vis[i][j] = true;

        
        for(int[] dir : dirs) {
            dfs(heights, i + dir[0], j + dir[1], p_vis, a_vis, heights[i][j]);
        }
    }
}
