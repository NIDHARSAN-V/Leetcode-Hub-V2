import java.util.*;

class Solution {
    int max = 0;
    Map<String, Integer> memo = new HashMap<>(); 

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        helper(root, 0, 0); 
        helper(root, 0, 1); 

        longestZigZag(root.left);
        longestZigZag(root.right);
        

        return max-1;
    }

    private int helper(TreeNode node, int parentDir, int dir) {
        if (node == null) return 0;

        String key = node.hashCode() + "-" + dir;
        if (memo.containsKey(key)) return memo.get(key);

        int res;
        if (dir == 0) {
            
            res = 1 + helper(node.left, dir, 1);
        } else {
            
            res = 1 + helper(node.right, dir, 0);
        }

        max = Math.max(max, res);
        memo.put(key, res);

        return res;
    }
}
