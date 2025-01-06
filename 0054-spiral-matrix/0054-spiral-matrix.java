class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row = 0;
        int col = 0;
        int m = matrix.length-1;
        int n = matrix[0].length-1;


        while(row <= m && col<=n )
        {
            // l to r
            for(int i = col ; i<=n ; i++)
            {
                res.add(matrix[row][i]);
            }
            row++;
            //

            for(int i = row ; i <= m ; i++)
            {
                res.add(matrix[i][n]);
            }
            n--;

           if(row <=m)
           {
            for(int i = n ; i>=col ; i--)
            {
                res.add(matrix[m][i]);
            }
            m--;
           }

           if(col <= n)
           {

            for(int i = m ; i>=row ; i--)
            {
                res.add(matrix[i][col]);
            }
            col++;
           }
            
        }
        return res;

    }
}
