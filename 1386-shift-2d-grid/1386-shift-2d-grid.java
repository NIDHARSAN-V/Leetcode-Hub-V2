class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        if (m == 0) return new ArrayList<>();
        int n = grid[0].length;
        int total = m * n;
        k = k % total; 

        List<List<Integer>> result = new ArrayList<>(m);
        
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int flatIndex = i * n + j;
                int newFlat = (flatIndex + k) % total;
                int newRow = newFlat / n;
                int newCol = newFlat % n;
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return result;
    }
}
