class Solution {
    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE;

        int pref = 1;
        int suff = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (pref == 0) pref = 1;

        
            if (suff == 0) suff = 1;

            pref *= nums[i];
            suff *= nums[n - 1 - i];

            res = Math.max(res, Math.max(pref, suff));
        }

        return res;
    }
}
