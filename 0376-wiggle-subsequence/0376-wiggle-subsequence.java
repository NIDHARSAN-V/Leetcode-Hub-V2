class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<=1)
        {
            return 1;
        }
        int u = 1;
        int d = 1;

        for(int i = 1 ; i < n ; i++)
        {
            if(nums[i]  > nums[i-1])
            {
                u = d + 1;
            }
            else if(nums[i] < nums[i-1])
            {
                d = u +1;
            }
        }

        return Math.max(u ,d);
        
    }

    
}