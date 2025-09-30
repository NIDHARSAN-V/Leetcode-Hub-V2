class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        while (n > 1) {
            prefixsum(nums, n);
            n--; 
        }
        
        return nums[0]; 
    }

    private void prefixsum(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
    }
}
