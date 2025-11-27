class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        
        Map<Integer , Long> map = new HashMap<>();
        long prefix = 0;
        long res = Long.MIN_VALUE;

      
        map.put(0, 0L);

        for(int i = 0 ; i < nums.length ; i++)
        {
            prefix += nums[i];

            int rem = (i + 1) % k;

            if(map.containsKey(rem))
            {
                res = Math.max(res, prefix - map.get(rem));
            }

            
            map.put(rem, Math.min(map.getOrDefault(rem, Long.MAX_VALUE), prefix));
        }

        return res;
    }
}
