class Solution {
    public int minDays(int[] blo, int m, int k) {
        int left = Integer.MAX_VALUE;
        int right  =Integer.MIN_VALUE;

        for(int i  : blo)
        {
            if(i < left)
            {
                left =i;
            }
            if(i > right)
            {
                right = i;
            }
        }
        int res = -1;

        while(left <= right)
        {
            int boq_count = 0;
            int each_iter_count =0;
            int mid = left + (right - left)/2;
             for(int i =0 ;i<blo.length ;i++)
             {
                if(blo[i] <=mid)
                {
                    each_iter_count++;
                    if(each_iter_count == k)
                    {
                        boq_count++;
                        each_iter_count =0;
                    }
                }
                else
                {
                     each_iter_count = 0 ;
                }
             }

             if(boq_count >= m )
             {
                 right = mid - 1;
                 res = mid;
             }
             else
             {
                left = mid + 1;
             }


        }
        

        return res;
    }
}