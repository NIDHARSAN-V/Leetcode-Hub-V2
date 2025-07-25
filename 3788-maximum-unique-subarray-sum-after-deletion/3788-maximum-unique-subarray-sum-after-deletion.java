class Solution {
    public int maxSum(int[] nums) {
        int neg  = 1;

        int max = Integer.MIN_VALUE;

        for(int n : nums)
        {
           if(n>=0)
           {
             neg = 0;
           }

           if(n > max)
           {
              max = n;
           }
        }

        if(neg==1){
            
            return max;
        }


        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }

        
        int sum = 0;
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }

        return sum;
        
    }
}