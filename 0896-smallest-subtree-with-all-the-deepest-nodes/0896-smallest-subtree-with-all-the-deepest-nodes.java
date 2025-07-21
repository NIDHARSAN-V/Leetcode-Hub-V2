class Solution {
    int maxdep = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Step 1: find the max depth
        maxdep = getDepth(root);

        // Step 2: find the LCA of all deepest nodes
        return dfs(root, 0);
    }

    // Computes the max depth of the tree
    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    // Returns the subtree with all deepest nodes
    private TreeNode dfs(TreeNode node, int depth) {
        if (node == null) return null;
        if (depth == maxdep - 1 && node.left == null && node.right == null) {
            return node;
        }

        TreeNode left = dfs(node.left, depth + 1);
        TreeNode right = dfs(node.right, depth + 1);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
}
