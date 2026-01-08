class Solution {

    private long max = 0;  
    private long total = 0;   
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        total = totalHelper(root);  
        helper(root);          
        return (int)(max % MOD);    
    }

    private long helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long leftsum = helper(root.left);
        long rightsum = helper(root.right);

        long cursum = root.val + leftsum + rightsum;

        
        max = Math.max(max, cursum * (total - cursum));

        return cursum;
    }

    private long totalHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + totalHelper(root.left) + totalHelper(root.right);
    }
}
