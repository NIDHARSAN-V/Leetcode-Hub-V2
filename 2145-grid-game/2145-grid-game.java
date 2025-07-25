class Solution {
    public long gridGame(int[][] grid) {
        long top = 0;
        long res  = Long.MAX_VALUE;
        long bottom  = 0;
        for(int i =0 ; i < grid[0].length ; i++)
        {
            top+=grid[0][i];
        }
        for(int i = 0; i < grid[0].length ; i++)
        {
            top-=grid[0][i];
            res = Math.min(res , Math.max(top , bottom));
            bottom+=grid[1][i];
        }
        return res;
    }
}