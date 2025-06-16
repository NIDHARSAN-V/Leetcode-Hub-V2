class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums , 0 , res , new ArrayList<>() );
        return res;
    }

    private void helper(int[] nums , int start ,List<List<Integer>> res , List<Integer> curr)
    {
        if(start == nums.length)
        {
         res.add(new ArrayList<>(curr));
         return;
        }
        for(int i  = start ; i < nums.length ; i++)
        {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            
            curr.add(nums[start]);
            helper(nums , start + 1 , res , curr);
            curr.remove(curr.size() - 1);
            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;

        }
        return;
    }
}