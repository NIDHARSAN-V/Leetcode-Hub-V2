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
    private int count =0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
        {
            return 0;
        }
        helper(root , sum , 0);
        pathSum(root.left , sum);
        pathSum(root.right , sum);
        return count;
    }

    private void helper(TreeNode root  , int sum , long cur)
    {
        if(root == null)
        {
            return;
        }
        cur+=root.val;
        if(cur == sum)
        {
            count++;
        }
        helper(root.left , sum , cur);
        helper(root.right , sum , cur);
    }
}