class Solution {
    public int minOperations(int[] nums, int x) {
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        int tar = tot - x;
        if (tar < 0) return -1;  
        if (tar == 0) return nums.length; 

        int l = 0;
        int cursum = 0;
        int maxlen = -1;

        for (int i = 0; i < nums.length; i++) {
            cursum += nums[i];

            while (cursum > tar && l <= i) {
                cursum -= nums[l];
                l++;
            }

            if (cursum == tar) {
                maxlen = Math.max(maxlen, i - l + 1);
            }
        }

        return maxlen == -1 ? -1 : nums.length - maxlen;
    }
}
