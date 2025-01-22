class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int st_x  =0 , st_y=0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 0)
                {
                    zero++;
                }
                else if(grid[i][j]==1)
                {
                    st_x = i;
                    st_y = j;
                }
            }
        }

        return dfs_helper(grid , st_x , st_y , zero);
    }


    private int dfs_helper(int[][] grid  , int i , int j , int zero )
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 )
        {
            return 0;
        }


        if(grid[i][j]==2)
        {
            return zero == -1 ? 1 : 0;
        }

      
        grid[i][j] =-1;
        int res = dfs_helper(grid , i+1 , j , zero -1) + dfs_helper(grid , i , j+1 , zero - 1)+ dfs_helper(grid , i-1 , j , zero - 1)+ dfs_helper(grid , i , j-1, zero - 1);
        grid[i][j] =0;
       

     return res;

    }
}