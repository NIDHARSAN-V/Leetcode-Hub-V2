import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

    
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }

     
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            colMax[j] = max;
        }


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
