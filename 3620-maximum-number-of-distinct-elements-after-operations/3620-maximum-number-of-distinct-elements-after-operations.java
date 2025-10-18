class Solution {
    public int maxDistinctElements(int[] nums, int k) {

        Arrays.sort(nums);
        int next = Integer.MIN_VALUE;
        int res = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            int lb = nums[i] - k ;
            int rb = nums[i] + k ;

            
            nums[i] = Math.max(lb , next); // check for the max value  --> next is the boundary 
            
            if(nums[i] <= rb) // multiple value with same value 2*k times
            {
                res++;
                next =  nums[i] + 1;
            }
            

        }
        return res;
    }
}