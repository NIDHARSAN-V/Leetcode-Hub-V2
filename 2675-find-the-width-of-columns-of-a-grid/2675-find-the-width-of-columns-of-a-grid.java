class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        Arrays.fill(res , Integer.MIN_VALUE);
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                res[j] = Math.max(res[j] , String.valueOf(grid[i][j]).length());
            }
        }
        return res;
    }
}