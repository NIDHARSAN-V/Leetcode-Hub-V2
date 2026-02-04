class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int x = n - 1;
        int y = 0;

        for (int i = 0; i < n - 1; i++) {

            if (x == n - 1 && nums[i] >= nums[i + 1]) {
                x = i;
            }

            if (y == 0 && nums[n - 1 - i] <= nums[n - 2 - i]) {
                y = n - 1 - i;
            }

            if (x != n - 1 && y != 0) {
                break;
            }
        }

        if (x >= y) return false;
        if (x == 0 || y == n - 1) return false;

        for (int i = x; i < y; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }

        return true;
    }
}
