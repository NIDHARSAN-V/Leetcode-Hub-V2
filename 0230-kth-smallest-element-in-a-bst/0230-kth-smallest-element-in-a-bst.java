class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[]{k});
    }

    private int inorder(TreeNode node, int[] k) {
        if (node == null) return -1;

        
        int left = inorder(node.left, k);
        if (k[0] == 0) return left;  

        
        k[0]--;  
        if (k[0] == 0) return node.val; 

        
        int right =  inorder(node.right, k);
        if (k[0] == 0) return right; 

        return -1;

    }
}
