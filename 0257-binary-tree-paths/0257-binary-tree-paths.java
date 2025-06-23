
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res  = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root , sb , res);
        return res;

    }

    private void helper(TreeNode root , StringBuilder sb , List<String> res )
    {
        
         if(root ==null)
         {
            return ;
         }
        int len = sb.length();
        sb.append(root.val);


        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        else
        {
                sb.append("->");
                helper(root.left , sb , res);
                helper(root.right , sb , res);

        }
        sb.setLength(len);

        return;  
    }
}