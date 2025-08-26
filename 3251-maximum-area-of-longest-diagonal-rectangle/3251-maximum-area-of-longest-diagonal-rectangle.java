class Solution {
    public int areaOfMaxDiagonal(int[][] dim) {
        int maxd = -1;   
        int maxArea = -1;    

        for (int[] d : dim) {

            int l = d[0], w = d[1];

            int diag = l * l + w * w;


            int area = l * w;
            if (diag > maxd || (diag == maxd && area > maxArea)) {
                maxd = diag;
                maxArea = area;
            }
        }

        return maxArea;
    }
}
