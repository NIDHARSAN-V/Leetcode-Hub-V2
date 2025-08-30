class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        Map<Integer, int[]> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rc = new int[m];
        int[] cc = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            int r = pos[0];
            int c = pos[1];

            rc[r]++;
            cc[c]++;

            if (rc[r] == n || cc[c] == m) {
                return i;
            }
        }
        return -1;
    }
}
