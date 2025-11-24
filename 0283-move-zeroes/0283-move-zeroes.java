class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = left + 1;
        int temp;
        while(right < nums.length)
        {
            if(nums[right]!=0)
            {
                while(left < right && nums[left]!=0)
                {
                    left++;
                }

                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                
            }
            right++;
        }
    }
}