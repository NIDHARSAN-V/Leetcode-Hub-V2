class Solution {
    int maxsum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxsum;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

    
        if (left[0] == 1 && right[0] == 1 && root.val > left[3] && root.val < right[2]) {
            int sum = left[1] + right[1] + root.val;
            maxsum = Math.max(maxsum, sum);

            int min = Math.min(root.val, left[2]);
            int max = Math.max(root.val, right[3]);

            return new int[]{1, sum, min, max};
        }

    
        return new int[]{0, 0, 0, 0};
    }
}
