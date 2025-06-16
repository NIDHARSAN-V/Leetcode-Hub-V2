class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(), 0, target);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int index, int target) {
        // Base cases
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (index == nums.length || target < 0) {
            return;
        }

        // Include the current element
        curr.add(nums[index]);
        helper(nums, res, curr, index, target - nums[index]); // stay on the same index for reuse
        curr.remove(curr.size() - 1); // backtrack

        // Exclude the current element and move to the next
        helper(nums, res, curr, index + 1, target);
    }
}
