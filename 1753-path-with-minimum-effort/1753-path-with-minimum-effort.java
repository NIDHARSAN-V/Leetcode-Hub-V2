class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[][]mineff = new int[r][c];
        for (int[] row : mineff) Arrays.fill(row, Integer.MAX_VALUE);
        mineff[0][0] = 0;

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
             int[] curr = pq.poll();
             int curr_eff = curr[0];
             int i = curr[1];
             int j = curr[2];

             //end
             if(i==r-1 && j==c-1)
             {
                return curr_eff;
             }
             
             for(int[] d  : dirs)
             {
                int ni = i + d[0];
                int nj = j + d[1];

                //base check 
                if(ni>=0 && ni<r && nj>=0 && nj<c)
                {
                    int nexteff = Math.max(curr_eff , Math.abs(heights[ni][nj] - heights[i][j]));
                    if(nexteff < mineff[ni][nj])
                    {
                        mineff[ni][nj] = nexteff;
                        pq.offer(new int[]{mineff[ni][nj] , ni , nj});
                    }
                }
             }
             
        }
        return 0; 
    }
}