class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp = 0;
        
         for(int i=0;i<m;i++)
         {
            for(int j=i+1;j<n;j++)
            {
             temp = matrix[i][j];
             matrix[i][j] = matrix[j][i];
             matrix[j][i] = temp;
            }
         }

        int x=0;
        int y = n-1;
         for(int i =0;i<m;i++)
         {
            x=0;
            y = n-1;
            while(x<y)
            {
                temp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = temp;
                x++;
                y--;
            }

         }
         
    }
}