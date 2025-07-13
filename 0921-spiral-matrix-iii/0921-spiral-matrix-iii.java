class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int count = 0;
        int n = 0;    
        int d = 0;     
        int[][] result = new int[rows * cols][2];

        result[count++] = new int[]{rStart, cStart}; 

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

        while (count < rows * cols) {

            // east or west inc
            if (d == 0 || d == 2) n++;

            for (int i = 0; i < n; i++) {
                rStart += dir[d][0];
                cStart += dir[d][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[count++] = new int[]{rStart, cStart};
                }

                if (count == rows * cols) return result;
            }

            d = (d + 1) % 4; 
        }

        return result;
    }
}
