class Solution {
    public int calc(int[] weight , int target)
    {
        int day = 1;
        int curr=0;
        for(int i=0;i<weight.length;i++)
        {
            curr += weight[i];
            if(curr>target)
            {
                day+=1;
                curr = weight[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int max= 0;
        int sum =0;
        for(int i=0 ; i<weights.length;i++)
        {
            max = Math.max(max,weights[i]);
            sum+= weights[i];
        }

        int left = max;
        int right  = sum;
        int ans =0;
        while(left<=right)
        {
            int cur = left + (right - left)/2;
            int numday = calc(weights , cur);

            if(numday > days)
            {
                left = cur +1;
            }
            else if(numday <= days)
            {
                ans = cur;
                right = cur -1;
            }
        }
        return ans;
        
    }
}