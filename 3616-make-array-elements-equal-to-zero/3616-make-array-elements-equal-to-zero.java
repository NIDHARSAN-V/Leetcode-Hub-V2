class Solution {
    public int countValidSelections(int[] nums) {
        int[] lsum = new int[nums.length];
        int[] rsum = new int[nums.length];
        lsum[0] = nums[0];
        rsum[nums.length -1] = nums[nums.length-1];

        for(int i = 1 ; i < nums.length ; i++)
        {
            lsum[i] = lsum[i-1] + nums[i];                                                  
        }
        for(int i = nums.length - 2; i >=0 ; i--)
        {
            rsum[i] = rsum[i+1] + nums[i];                                                  
        }

        int res = 0;
        for(int i = 0 ; i < nums.length ;i++)
        {
            if(nums[i] == 0)
            {
                if(lsum[i] - rsum[i] == 0)
                {
                    res+=2;
                }
                else if(Math.abs(lsum[i] - rsum[i])==1)
                {
                    res++;
                }
            }
        }
        return res;
    }
}