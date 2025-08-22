class Solution {
    public int numSubmat(int[][] mat) {
       int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

      
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1) {

                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

                }


                //computing the row wise

                int min = dp[i][j];

                for(int x = i ; x>=0  ; x--)
                {
                    min  = Math.min(dp[x][j] , min);
                    res+=min;
                }


            }



        }
        return res;
    }
}