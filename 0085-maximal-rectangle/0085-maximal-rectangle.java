class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int ch = (i == heights.length) ? 0 : heights[i];

            while (!stk.isEmpty() && ch < heights[stk.peek()]) {
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                max = Math.max(max, h * w);
            }

            stk.push(i);
        }

        return max;
    }
}
