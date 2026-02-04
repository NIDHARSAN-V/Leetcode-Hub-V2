class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int x = -1;
        int y = -1;

        for (int i = 0; i < n - 1; i++) {

            if (x == -1 && nums[i] >= nums[i + 1]) {
                x = i;
            }

            if (y == -1 && nums[n - 1 - i] <= nums[n - 2 - i]) {
                y = n - 1 - i;
            }

            if (x != -1 && y != -1) {
                break;
            }
        }

        if (x == -1 || y == -1) return false;
        if (x >= y) return false;
        if (x == 0 || y == n - 1) return false;

        for (int i = x; i < y; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }

        return true;
    }
}
