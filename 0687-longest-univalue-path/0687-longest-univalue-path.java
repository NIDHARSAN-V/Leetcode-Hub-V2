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
    private int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        helper(root , root.val);
        return res;
    }

    private int helper(TreeNode root , int prev)
    {
        if(root == null)
        {
            return 0;
        }

        int left  =  helper(root.left , root.val);
        int right  =  helper(root.right , root.val);
        
        res = Math.max(res , left +  right);

        if(root.val == prev)
        {
            return 1 + Math.max(left , right);
        }

        return 0;

        
    }



}