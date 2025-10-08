class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
      
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
       
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, jobs[i][1]);
            jobs[i][1] = maxProfit;
        }
        
      
        Arrays.sort(worker);
        int res = 0;
        
        
        for (int w : worker) {
            int left = 0, right = n - 1;
            int best = 0;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (jobs[mid][0] <= w) {
                    best = jobs[mid][1]; 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            res += best;
        }
        
        return res;
    }
}
