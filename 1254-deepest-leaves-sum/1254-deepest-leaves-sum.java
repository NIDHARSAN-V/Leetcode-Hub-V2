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
    private int fin_level=0;
    private int sum=0;

    public int deepestLeavesSum(TreeNode root) {
        helper(root , 0);
        return sum;
    }
    private void helper(TreeNode root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level > fin_level )
        {
            fin_level = level;
            sum = 0;
        }
        helper(root.left , level + 1);
        helper(root.right , level + 1);
        if(level == fin_level)
        {
            sum+=root.val;
        }
        return;
    }
}