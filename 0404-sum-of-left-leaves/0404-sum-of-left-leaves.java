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
    private int sum =0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root , false);
        return sum;
    }

    private void helper(TreeNode root , boolean left)
    {
          if(root == null)
          {
            return;
          }
          if(left==true && root.right==null && root.left==null)
          {
            sum+=root.val;
          }
          helper(root.left , true);
          helper(root.right , false);
          return;
    }
}