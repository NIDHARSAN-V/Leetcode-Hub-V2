class Solution {
    public int countPartitions(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int total = prefix[prefix.length - 1];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            int left = prefix[i - 1];
            int right = total - left;

            if ((right - left) % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}