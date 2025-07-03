/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       helper(root , p , q);
       return res;
    }

    private boolean helper(TreeNode root, TreeNode p , TreeNode q)
    {
        if(root == null)
        {
            return false;
        }
        boolean  left = helper(root.left , p , q);
        boolean  right = helper(root.right , p , q);
        boolean  curr_is_anc= (root == p || root == q);

        if ((left && right) || (curr_is_anc && left) || (curr_is_anc && right)) {
            res = root;
        }

        return left || right || curr_is_anc;

    }
}