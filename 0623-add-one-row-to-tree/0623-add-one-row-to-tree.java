class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: insert new root
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, null, val, depth - 1);
        return root;
    }

    public void dfs(TreeNode root, TreeNode prev, int val, int depth) {
        if (root == null) return;

        // First go left and right (post-order traversal)
        dfs(root.left, root, val, depth - 1);
        dfs(root.right, root, val, depth - 1);

        // Now process the current node
        if (depth == 1) {
            TreeNode nl = new TreeNode(val);
            TreeNode nr = new TreeNode(val);

            nl.left = root.left;
            root.left = nl;

            nr.right = root.right;
            root.right = nr;
        }
    }
}
