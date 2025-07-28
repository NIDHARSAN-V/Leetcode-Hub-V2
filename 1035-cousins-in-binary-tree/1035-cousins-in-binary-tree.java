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
    int xlevel = -1;
    int ylevel = -1;
    TreeNode xpar = null;
    TreeNode ypar = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root ,null , x , y ,0 );
        if(xlevel == ylevel && xpar!=ypar)
        {
            return true;
        }
        return false;
    }


    private void helper(TreeNode root , TreeNode parent  , int x , int y , int dep)
    {
        if(root == null)
        {
            return;
        }

        if(root.val==x)
        {
            xlevel = dep;
            xpar = parent;
        }
        if(root.val == y)
        {
            ylevel =dep;
            ypar  = parent;
        }


        helper(root.left , root  , x , y , dep+1);
        helper(root.right , root  , x , y , dep+1);
    }



}