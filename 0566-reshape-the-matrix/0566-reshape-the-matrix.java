class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int rr = mat.length;
        int cc = mat[0].length;
        if(r*c != rr*cc)
        {
            return mat;
        }
        for(int i = 0 ; i < r*c ; i++)
        {
            res[i/c][i%c] = mat[i/cc][i%cc];
        }
        return res;
    }
}