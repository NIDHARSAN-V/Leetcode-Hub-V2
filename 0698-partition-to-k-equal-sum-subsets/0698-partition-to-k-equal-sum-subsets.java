class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum = 0;
       for(int i : nums)
       {
        sum += i;
       }
       if(sum % k !=0)
       {
        return false;
       }
       boolean[] vis =  new boolean[nums.length];
       Arrays.fill(vis , false);
       return helper(nums , k , sum/k ,0, vis , 0);
    }

    private boolean helper(int[] nums ,  int k , int target , int cursum ,boolean[] vis, int start)
    {
       if(k==0)
       {
        return true;
       }
       if(cursum == target)
       {
        return helper(nums , k - 1 , target , 0 , vis , 0);
       }
       for(int i = start ; i < nums.length ; i++)
       {
          if(vis[i]  || (cursum + nums[i]) > target)
          {
            continue;
          }
          vis[i] = true;
          if(helper(nums , k , target , cursum + nums[i] , vis , i+1))
          {
            return true;
          }
          else
          {
          vis[i] = false;

          }
        
    

       }

       return false;
    }
}