class Solution {
    private TreeNode first = null; // First misplaced node
    private TreeNode second = null; // Second misplaced node
    private TreeNode prev = null; // Keeps track of the previous node during traversal

    public void recoverTree(TreeNode root) {
        inorder(root);

      
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev; 
            }
            second = node;  // for the correct tracking of the node like 4 3 2 -1(right)
        }
        prev = node; //asc check 

        inorder(node.right); 
    }
}