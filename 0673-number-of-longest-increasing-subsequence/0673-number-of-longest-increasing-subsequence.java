class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] t = new int[nums.length];

        int[] c = new int[nums.length];
        Arrays.fill(t , 1);
        Arrays.fill(c , 1);
        int max = 1;
        for(int i =1 ;  i<nums.length ; i++)
        {
            for(int j = 0 ; j<i ; j++)
            {
                if(nums[i] > nums[j])
                {
                    if(t[i] < 1  + t[j])
                    {
                        t[i] = 1 + t[j]; 
                        c[i] = c[j]; 
                    }
                    else if(t[i] == 1 + t[j])
                    {
                        c[i] += c[j];
                    }
                }
            }
            if(max < t[i])
            {
                max = t[i];
            }
        }
        int count =0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(t[i] == max)
            {
              count+=c[i];
            }
        }

        return count;
     }
}