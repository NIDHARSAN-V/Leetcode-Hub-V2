class Solution {


    private boolean helper(int[] bloom ,int mid ,  int m , int k)
    {
        int kk  =0;
        int c = 0;
        for(int i = 0 ; i < bloom.length ; i++)
        {
             if(bloom[i] <= mid )
             {
                c++;
                if(c == k)
                {
                    kk++;
                    c = 0;
                }
             }
             else
             {
                c = 0;
             }
        }
        return  kk >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int min  = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        for(int i : bloomDay)
        {
            min = Math.min(min , i);
            max = Math.max(max , i);
        }
        int ans = Integer.MIN_VALUE;
        int t = ans;

        while(min <= max)
        {
           int mid  = min + (max - min)/2;

           if(helper( bloomDay, mid , m , k))
           {
              ans = mid;
              max = mid - 1;
           }
           else
           {
              min = mid + 1;
           }
        }


        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
}