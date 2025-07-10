public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modIndexMap = new HashMap<>();

        modIndexMap.put(0, -1);

        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int mod = k != 0 ? prefixSum % k : prefixSum;
            
            if (modIndexMap.containsKey(mod)) {

                if (i - modIndexMap.get(mod) > 1) {

                    return true;

                }

            }

            else
            {

            modIndexMap.put(mod, i);
            }
        }
        return false;
    }
}
