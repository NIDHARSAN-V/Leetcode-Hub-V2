

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int i = 0, j = 0;

        while (i < nums.length) {
            if (!set.contains(nums[i])) {
                sum += nums[i];
                max = Math.max(max, sum);
                set.add(nums[i]);
                i++;
            } else {
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
        }

        return max;
    }
}
