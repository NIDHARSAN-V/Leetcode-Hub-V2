class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer , Integer> dp = new HashMap<>();
        return helper(nums, target, 0 ,dp);
    }

    private int helper(int[] nums, int target, int i , Map<Integer , Integer> map) {
        if (target == 0) return 1;
        if (target < 0 || i >= nums.length) return 0;
        if(map.containsKey(target))
        {
             return map.get(target);
        }
        
        int include = helper(nums, target - nums[i], 0 , map);
        int exclude = helper(nums, target, i + 1 , map); //simulates for loop
        map.put(target , include + exclude);

        return  include+exclude;
    }
}
