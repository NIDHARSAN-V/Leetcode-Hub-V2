class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length ; i++)
        {
            if(min < nums[i])
            {
                maxdiff = Math.max(maxdiff ,nums[i] - min);
            }
            else
            {
                min = nums[i];
            }
        }

        return maxdiff;

    }
}