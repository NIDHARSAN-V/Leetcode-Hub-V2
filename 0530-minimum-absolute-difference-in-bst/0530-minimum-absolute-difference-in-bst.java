/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }


    public void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }


        helper(root.left);

        if(prev!=null)
        {
            min = Math.min(min , Math.abs(root.val - prev.val));
        }
        prev = root;

        helper(root.right);
        return;
    }
}