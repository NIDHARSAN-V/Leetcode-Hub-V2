class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count =0 ;

        int start=0;
        int end=0;
        while(end < nums.length )
        {
            if(nums[end] - nums[start] <= k)
            {
                end++;
                // continue;
            }
            else
            {
                count++;
                start  = end;
                end++;
            }
            
        }
        return count + 1;

        


    }
}