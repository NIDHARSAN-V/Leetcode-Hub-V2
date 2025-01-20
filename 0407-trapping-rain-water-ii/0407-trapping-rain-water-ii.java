class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] visited=new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    pq.add(new int[]{heightMap[i][j], i, j});
                    visited[i][j]=true;
                }
            }
        }

        int[][] dir = {{0,1} , {1,0} , {-1,0} , {0,-1}};

        int res_water = 0;

        while(!pq.isEmpty())
        {
            int[] val  = pq.poll();



            for(int[] d : dir)
            {
                int new_row = val[1] + d[0]; 
                int new_col = val[2] + d[1]; 

            if(new_row >=0 && new_row<m && new_col>=0 && new_col < n && !visited[new_row][new_col])
            {
                visited[new_row][new_col] =  true;
                if(val[0] -  heightMap[new_row][new_col] > 0)
                {
                    res_water += val[0] -  heightMap[new_row][new_col];
                    pq.add(new int[]{val[0] , new_row , new_col});
                }
                else
                {
                    pq.add(new int[]{heightMap[new_row][new_col] , new_row , new_col});
                }
            }
            }
        }
        return res_water;

    }
}