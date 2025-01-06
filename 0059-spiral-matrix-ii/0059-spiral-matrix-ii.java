class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix  = new int[n][n];
        int num=1;
        int row =n -1;
        int col = n-1;
        int i =0;
        int j=0;
        int irow=0;
        int icol =0;
        while(irow<=row && icol<=col)
        {

            //ltor
            for(j=icol;j<=col;j++)
            {
                matrix[irow][j] = num++;
            }
            irow++;
            //top to bottom
            for(i=irow;i<=row;i++)
            {
                matrix[i][col]=num++;
            }
            col--;
            ///r to l 
            if(irow<=row)
            {
            for(j=col ;j>=icol;j--)
            {
                matrix[row][j]=num++;
            }
            row--;
            }
            //b to t
            if(icol<=col)
            {
            for(i = row ;i>=irow ;i-- )
            {
               matrix[i][icol]=num++;
            }
            icol++;
            }

        }
        return matrix;
    }
}