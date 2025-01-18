class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target , 0);
        result[1] = findFirst(nums, target ,1);
        return result;
    }
    
    private int findFirst(int[] nums, int target , int x) {
        int left = 0, right = nums.length - 1;
        int index = -1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid; 
                if(x==0)
                  right = mid - 1;
                else if(x==1)
                  left = mid+1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
    
}
