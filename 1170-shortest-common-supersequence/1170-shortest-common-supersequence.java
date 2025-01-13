class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp  = new int[str1.length() +1][str2.length()+1];
        
        for(int i = 1 ; i<=str1.length();i++)
        {
            for(int j = 1 ; j<=str2.length() ; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = str1.length() , y =str2.length();
        while (x > 0 && y > 0) {
            if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
                sb.append(str1.charAt(x - 1));
                x--;
                y--;
            } else {
                if (dp[x][y - 1] > dp[x - 1][y]) {
                    sb.append(str2.charAt(y - 1));
                    y--;
                } else {
                    sb.append(str1.charAt(x - 1));
                    x--;
                }
            }
        }

        // If there are remaining characters in str1, append them
        while (x > 0) {
            sb.append(str1.charAt(x - 1));
            x--;
        }

        // If there are remaining characters in str2, append them
        while (y > 0) {
            sb.append(str2.charAt(y - 1));
            y--;
        }

        return sb.reverse().toString();
    } 
}