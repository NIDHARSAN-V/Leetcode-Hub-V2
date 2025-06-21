class Solution {
    public int rob(TreeNode root) {
        List<Integer> result = helper(root);

        return Math.max(result.get(0), result.get(1));
    }

   
    public List<Integer> helper(TreeNode root) {
        if (root == null) {
            return Arrays.asList(0, 0);
        }

        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);

      return Arrays.asList(Math.max(left.get(0), left.get(1)) + Math.max(right.get(0), right.get(1)),  root.val + left.get(0) + right.get(0)                                     
);
    }

}
