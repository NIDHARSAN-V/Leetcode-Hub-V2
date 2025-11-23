class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, min = nums[0];
        for (int n : nums) {
            sum += n;
           
        }
        return sum - nums.length * min;
    }
}