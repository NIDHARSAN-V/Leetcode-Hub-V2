class Solution {
    int maxDepth = -1;
    int bottomLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0, 0); 
        return bottomLeftValue;
    }

    private void dfs(TreeNode node, int depth, int dir) {
        if (node == null) return;

        
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.val;
        }

        
        dfs(node.left, depth + 1, 0);
        dfs(node.right, depth + 1, 1);
    }
}
