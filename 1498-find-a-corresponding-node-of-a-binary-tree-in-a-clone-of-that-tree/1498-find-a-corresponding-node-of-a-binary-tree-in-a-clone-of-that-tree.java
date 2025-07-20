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
    TreeNode output=new TreeNode();
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        getCopy(cloned,target);
        return output;
    }
    public void getCopy(TreeNode root,TreeNode target)
    {
        if(root==null)return;
        getCopy(root.left,target);
        if(root.val==target.val)
        {
            output=root;
        }
        getCopy(root.right,target);
    }
}