class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        int prefixSum = 0;

        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < n; i++) {
           
            prefixSum += nums[i] == 0 ? -1 : 1;

            
            if (map.containsKey(prefixSum)) {
                
                max = Math.max(max, i - map.get(prefixSum));
            } else {
                
                map.put(prefixSum, i);
            }
        }

        return max;
    }
}
