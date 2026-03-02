class Solution {
    public int minSwaps(int[][] grid) {
        int r = grid.length;
        int n = grid.length;
        int c = grid[0].length;
        int swap = 0;
        int[] temp = new int[r];
       for(int i = 0 ; i < r ; i++)
       {
            int x = 0;
           for(int j = n-1 ; j>=0 && grid[i][j]==0 ; j--)
           {
                    if(grid[i][j]==0)
                    {
                        x++;
                    }
           }

           temp[i] = x;
       }


       for(int i = 0 ; i < r ; i++)
       {
        int need = r - i - 1;
        int  x  = i;

        while(x < n && temp[x] < need)
        {
            x++;
        }

        if(x==n)
        {
            return -1;
        }

        while(i<x)
        {
            int t = temp[x];
            temp[x] = temp[x-1];
            temp[x-1] = t;
            swap++; 
            x--;
        }

        
       }





       return swap;
    }
}