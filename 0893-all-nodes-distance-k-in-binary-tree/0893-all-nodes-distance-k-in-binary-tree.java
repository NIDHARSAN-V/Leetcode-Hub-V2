/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        preorder(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();

        q.offer(target);
        vis.add(target);

        while (!q.isEmpty() && k > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (parent.get(curr) != null && !vis.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    vis.add(parent.get(curr));
                }
                if (curr.left != null && !vis.contains(curr.left)) {
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    q.offer(curr.right);
                    vis.add(curr.right);
                }
            }
            k--;
        }

        List<Integer> res = new ArrayList<>();
        for (TreeNode node : q) {
            res.add(node.val);
        }

        return res;
    }

    private void preorder(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }

        parent.put(root, par);
        preorder(root.left, root, parent);
        preorder(root.right, root, parent);
    }
}
