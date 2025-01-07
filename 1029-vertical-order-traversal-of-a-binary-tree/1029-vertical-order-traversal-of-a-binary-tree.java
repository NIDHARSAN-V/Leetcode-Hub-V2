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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer , Map<Integer ,List<Integer>>> tree = new TreeMap<>();

        inorder(tree , root , 0 , 0);
        for(var col  : tree.entrySet())
        {
            List<Integer> temp = new ArrayList<>();
            for(var row : col.getValue().values())
            {
                Collections.sort(row);
                temp.addAll(row);
            }
            res.add(temp);
        }
        return res;


    }



    private void inorder(TreeMap<Integer , Map<Integer ,List<Integer>>> tree , TreeNode root , int level ,int col)
    {
        if(root == null)
        {
            return;
        }
        if(!tree.containsKey(col))
        {
            tree.put(col , new TreeMap<>());
        }
        if(!tree.get(col).containsKey(level))
        {
            tree.get(col).put(level , new ArrayList<>());
        }
        tree.get(col).get(level).add(root.val);

        inorder(tree , root.left , level+1 , col-1); 
        inorder(tree , root.right , level+1 , col+1); 
        return;
    }
}