class Solution {


    private int helper(int[] nums , int mid) 
    {
        int ans = 0;
        for(int i = 0 ;i < nums.length ; i++)
        {
            ans+= Math.ceil((float)nums[i] / (float)mid);
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
       int r = Integer.MIN_VALUE;
       for(int i : nums)
       {
          r = Math.max(r , i);
       }
       int l = 1;
       int ans = r;

       while( l <=  r)
       {
         int mid = l + (r-l)/2;

         if(helper(nums , mid) <= threshold)
         {
            ans = mid;
            r = mid -1;
         }
         else
         {
            l = mid + 1;
         }

         
       }

       return ans;
    }
}