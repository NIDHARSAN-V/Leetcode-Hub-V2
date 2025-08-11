class Solution {
    public int maxSubArray(int[] nums) {
        int min  =0; 
        int max =0;
        int cursum = 0;
        int  maxsum =nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(cursum<0)
            {
                cursum=0;
            }
             cursum+=nums[i];
            

            maxsum =Math.max(maxsum , cursum);
            
            
        }
        return maxsum;
    }
}