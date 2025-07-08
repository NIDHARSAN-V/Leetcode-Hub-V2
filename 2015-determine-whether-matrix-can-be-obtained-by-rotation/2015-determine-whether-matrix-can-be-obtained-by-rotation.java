class Solution {
    public boolean findRotation(int[][] a, int[][] b) {
        int c0 = 0;
        int c90 = 0;
        int c180 = 0;
        int c270 = 0;
        int n  = a.length;
        for (int i = 0 ; i < n ; i++) {
    for (int j = 0 ; j < n ; j++) {
        if (a[i][j] == b[i][j])            c0++;     // 0°
        if (a[i][j] == b[j][n-1-i])        c90++;    // 90°
        if (a[i][j] == b[n-i-1][n-j-1])    c180++;   // 180°
        if (a[i][j] == b[n-j-1][i])        c270++;   // 270°
    }
}


        if(c90==n*n||c270==n*n||c180==n*n||c0==n*n)
        return true;
        else return false;
    }
}