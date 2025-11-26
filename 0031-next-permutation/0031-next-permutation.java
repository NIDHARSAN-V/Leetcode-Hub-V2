class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ii = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ii = i;
                break;
            }
        }

        if (ii == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int j = n - 1; j > ii; j--) {
            if (nums[j] > nums[ii]) {
                swap(nums, ii, j);
                break;
            }
        }

        reverse(nums, ii + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
