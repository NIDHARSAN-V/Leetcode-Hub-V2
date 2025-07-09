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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
    TreeNode newRoot = new TreeNode(val);
    newRoot.left = root;
    return newRoot;
}



        dfs(root , val ,depth-1);
        return root;
    }

    public void dfs(TreeNode root , int val , int depth)
    {
        if(root == null)
        {
            return;
        }

        if(depth==1)
        {
            TreeNode nl = new TreeNode(val);
            TreeNode nr = new TreeNode(val);
            
            TreeNode temp  = root.left;
            root.left = nl;
            nl.left = temp;

            temp  = root.right;
            root.right = nr;
            nr.right = temp;

            return;
            
        }
        else
        {
             dfs(root.left , val , depth-1);
             dfs(root.right , val , depth-1);
        }

       return;
    }
}