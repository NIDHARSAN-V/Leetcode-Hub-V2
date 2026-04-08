class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        int MOD = 1000000007;

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            if (k == 0) continue; 

            int idx = l;
             
            while (idx <= r) {
                nums[idx] = (int)((1L * nums[idx] * v) % MOD);
                idx += k;
            }
        }

        int res = 0;
        for (int i : nums) {
            res ^= i;
        }

        return res;
    }
}