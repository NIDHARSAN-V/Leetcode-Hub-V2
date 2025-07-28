class Solution {

    int max=0;
    int res=0;
    public int countMaxOrSubsets(int[] nums) {
     for(int x  : nums)
     {
        max|=x;
     }

     back(nums , 0 , 0);
     return res;

    }

    public void back(int[] nums , int start , int val)
    {
        if(max==val)
        {
            res++;
        }
        for(int i = start;i<nums.length;i++)
        {
          
           back(nums , i+1,val|nums[i]);
        }
    }
}