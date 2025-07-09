import java.util.*;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: new row becomes the new root
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        // Traverse level by level until reaching depth - 1
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentDepth == depth - 1) {
                // Add new nodes to each node at this level
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();

                    TreeNode tempLeft = current.left;
                    TreeNode tempRight = current.right;

                    current.left = new TreeNode(val);
                    current.left.left = tempLeft;

                    current.right = new TreeNode(val);
                    current.right.right = tempRight;
                }
                break; // We added the row, no need to go deeper
            }

            // Continue to the next level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            currentDepth++;
        }

        return root;
    }
}
