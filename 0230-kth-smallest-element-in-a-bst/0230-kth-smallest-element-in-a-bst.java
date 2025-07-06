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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li =new ArrayList<>();
        inorder(root , li);
        // System.out.print(li);
        return li.get(k-1);
    }

    private void inorder(TreeNode root,List<Integer> li)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left , li);
        li.add(root.val);
        inorder(root.right , li);
        
    }
}