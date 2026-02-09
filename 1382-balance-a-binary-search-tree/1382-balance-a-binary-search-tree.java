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


    private void inorder(TreeNode root , List<Integer> tr)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left , tr);
        tr.add(root.val);
        inorder(root.right , tr);

    }

    private TreeNode createBTree(List<Integer> tr , int l , int r )
    {
        if(l > r)
        {
            return null;
        }

        int mid = l + (r - l)/2;
        TreeNode rt = new TreeNode(tr.get(mid));
        rt.left =  createBTree(tr , l , mid -1);
        rt.right =  createBTree(tr , mid + 1 , r);
        return rt;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> node = new ArrayList<>();
        inorder(root , node);
        return createBTree(node ,0 , node.size() - 1);
    }
}