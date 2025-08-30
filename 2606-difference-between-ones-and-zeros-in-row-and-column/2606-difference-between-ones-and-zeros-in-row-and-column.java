class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, int[]> rowcount = new HashMap<>();
        Map<Integer, int[]> colcount = new HashMap<>();

        for (int i = 0; i < m; i++) rowcount.put(i, new int[2]);
        for (int j = 0; j < n; j++) colcount.put(j, new int[2]);

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val == 0 || val == 1) {
                    rowcount.get(i)[val]++;
                    colcount.get(j)[val]++;
                }
            }
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (rowcount.get(i)[1] + colcount.get(j)[1]) - (rowcount.get(i)[0] + colcount.get(j)[0]);
            }
        }

        return grid;
    }
}
