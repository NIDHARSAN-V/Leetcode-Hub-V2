class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;  
        int[] res = new int[m * n];
        int row = 0, col = 0, counter = 0;
        int dia = 0;  

        while (counter < m * n) {
            res[counter++] = mat[row][col];

            if (dia == 0) { 
                if (col == n - 1) {  
                    row++;
                    dia = 1;
                } else if (row == 0) {  
                    col++;
                    dia = 1;
                } else { 
                    row--;
                    col++;
                }
            } else { 
                if (row == m - 1) { 
                    col++;
                    dia = 0;
                } else if (col == 0) { 
                    row++;
                    dia = 0;
                } else { 
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
