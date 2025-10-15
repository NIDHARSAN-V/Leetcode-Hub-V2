class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] temp = new int[n];
        temp[0] = 1;
        Set<Integer> set = new HashSet<>();
        
        set.add(1);
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                temp[i] = temp[i - 1] + 1;
                set.add(temp[i]);
            } else {
                temp[i] = 1;
            }
        }

        int maxk = 0;

        int l = 1;
        int r = nums.size()/2;
        
        while( l <= r)
        {
           int k = l + (r-l)/2;
           
           if(isVaild(k,temp,n , set))
           {
              maxk = k;
              l = k+1;
           }
           else
           {
              r = k-1;
           }
        }
        
        

        return maxk;
    }



    private boolean isVaild( int k , int[] temp , int n , Set<Integer> set)
    {

        // if(k not present check in set )
        if(!set.contains(k))
        {
            return false;
        }
        for (int i = 0; i + 2 * k - 1 < n; i++) {
            if (temp[i + k - 1] >= k && temp[i + 2 * k - 1] >= k) {
                  return true; 
            }
        }
        return false;
    }
}
