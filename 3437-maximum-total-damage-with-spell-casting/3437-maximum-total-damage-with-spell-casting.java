class Solution {
    public long maximumTotalDamage(int[] power) {
         long[] dp = new long[power.length];
         Arrays.fill(dp , -1);
          Arrays.sort(power);
          return helper(power , 0 , dp);
    
    }

    private long helper(int[] power , int index , long[] dp)
    {
        if(index >= power.length)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        int i = index;
        int dup = 1;
        while((i+1) < power.length && power[i]==power[i+1])
        {
           dup++;
           i++;
        //    index++;
        }
        //include
        long skip =(long) helper(power , i+1 , dp);
        //exclude
        int nextvalindex = nextvalidindex(power , power[index] + 3 , index);
        long include =(long) power[index]*dup + helper(power , nextvalindex , dp);
        
        return dp[index] = Math.max(skip , include);
    }


    private int nextvalidindex(int[] power , int val , int index)
    {
       int left = index , right = power.length-1 , ans = power.length;

       while(left <= right)
       {
         int mid = (left + right) / 2;

         if(power[mid] >= val)
         {
            ans = mid;
            right = mid-1;
         }
         else
         {
            left = mid+1;
         }
       }
       return ans;
    }
}