class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
       int m = matrix.length;
       int n  =matrix[0].length;
       int n_count =0 ;
       int min  = Integer.MAX_VALUE;
       long sum=0;
       for(int i  =0 ;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(matrix[i][j]<0)
            {
                n_count++;
            }
            sum = sum+Math.abs(matrix[i][j]);
            min = Math.min(min  , Math.abs(matrix[i][j]));
        }
       }

       if(n_count%2==0)
       {
        return sum;
       }
       return sum - min*2;
    }
}