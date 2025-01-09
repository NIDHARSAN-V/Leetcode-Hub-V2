class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][matrix[0].length];
   
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }
     
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int up = dp[i-1][j];
                int right = j < matrix[0].length - 1 ? dp[i-1][j+1] : Integer.MAX_VALUE;
                
                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(up, right));
            }
        }
        
    
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            minSum = Math.min(minSum, dp[n-1][j]);
        }
        
        return minSum;
    }
}
