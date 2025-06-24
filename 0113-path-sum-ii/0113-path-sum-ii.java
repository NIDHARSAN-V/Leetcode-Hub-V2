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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curpath = new ArrayList<>();
        dfs(root , targetSum , curpath , res);
        return res;
    }

    private void dfs(TreeNode root , int targetSum ,List<Integer> cur , List<List<Integer>> res)
    {
          if(root==null)
          {
            return;
          }
          
          cur.add(root.val);

          if(root.left==null && root.right==null && targetSum == root.val)
          {
            res.add(new ArrayList<>(cur));
          }
          else
          {
            dfs(root.left , targetSum - root.val , cur , res);
            dfs(root.right , targetSum - root.val , cur , res);
          }

          cur.remove(cur.size()-1);
    }
}