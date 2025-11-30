class Solution {
    public int minOperations(int[] nums, int k) {
        int sm = 0;

        for(int i = 0 ; i < nums.length ;i++)
        {
            sm+=nums[i];
        }

        return sm%k;
    }
}