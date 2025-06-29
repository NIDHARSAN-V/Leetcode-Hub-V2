class Solution {
    int count = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode node, int maxSoFar) {
        if (node == null) return;

        if (node.val >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);

        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
    }
}
