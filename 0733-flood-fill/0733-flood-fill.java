class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (image[sr][sc] == color) {
            return image; 
        }
        
       
        int o_color = image[sr][sc];
      
        dfs(image, sr, sc, o_color, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int o_color, int n_color) {
    
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return; 
        }
        
       
        if (image[sr][sc] != o_color) {
            return;
        }
        
        image[sr][sc] = n_color;

        
        int[][] adj = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

       
        for (int[] ad : adj) {
            int r = sr + ad[0];
            int c = sc + ad[1];
            dfs(image, r, c, o_color, n_color); 
        }
    }
}
