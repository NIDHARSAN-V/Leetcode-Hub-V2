
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res  = new ArrayList<>();
     
    helper(root ,"" , res);
        return res;

    }

   private void helper(TreeNode root, String path, List<String> res) {
    if (root == null) return;

    path += root.val;

    if (root.left == null && root.right == null) {
        res.add(path);
    } else {
        path += "->";
        helper(root.left, path, res);
        helper(root.right, path, res);
    }
}

}