class Solution {
    public int longestSubarray(int[] nums) {
        int z_count =0 ;
        int left =0 ;
        int res =0 ;

        for(int i =0 ;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                z_count++;
            }
            while(z_count==2)
            {
                if(nums[left]==0)
                {
                    z_count--;
                }
                left++;
            }
            res = Math.max(res , i - left);
        }
        return res;
    }
}