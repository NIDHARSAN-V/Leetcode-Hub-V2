class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;  // This avoids potential overflow
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;  // Correctly move the left pointer
            } else {
                right = mid - 1;  // Correctly move the right pointer
            }
        }
        return -1;
    }
}
