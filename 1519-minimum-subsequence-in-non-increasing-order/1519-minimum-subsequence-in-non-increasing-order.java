class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int cursum = 0;

       
        for (int i = nums.length - 1; i >= 0; i--) {
            cursum += nums[i];
            result.add(nums[i]);
            if (cursum > totalSum - cursum) {
                break;
            }
        }

        return result;
    }
}
