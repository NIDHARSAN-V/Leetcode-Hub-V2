class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] res   = new int[nums.length];
        Arrays.fill(res ,  1);
        for(int i = 0 ; i <  nums.length ; i++)
        {
             res[i]=1;
             int j = i-1;

             while(j >=0 && ((nums[j] |nums[i]) != nums[j])) 
             {
                 res[j] = i-j  +1;
                 nums[j] = nums[j] | nums[i];
                 j--;
             }  
        }

        return res;
    }
}