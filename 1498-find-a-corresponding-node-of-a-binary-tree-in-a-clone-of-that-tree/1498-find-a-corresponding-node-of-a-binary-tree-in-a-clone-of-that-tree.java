class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getCopy(cloned, target);
    }

    public TreeNode getCopy(TreeNode root, TreeNode target) {
        if (root == null) return null;
        
        if (root.val == target.val) {
            return root;
        }

        TreeNode left = getCopy(root.left, target);
        TreeNode right = getCopy(root.right, target);
        if (left != null) return left;
        if(right!=null) return right;
        return null;
    }
}
