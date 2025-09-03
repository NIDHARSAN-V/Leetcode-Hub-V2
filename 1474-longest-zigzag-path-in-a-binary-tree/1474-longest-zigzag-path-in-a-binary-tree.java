
class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {

         if(root == null)
         {
            return 0;
         }

         helper(root.left , 1 , 0);
         helper(root.right , 1 , 1);


    
         return max;
         
    }


    private void helper(TreeNode root , int count , int dir )
    {
           if(root == null)
           {
            return ;
           }
           
           max = Math.max(max , count);

           if(dir == 0)
           {
              helper(root.right , count + 1  , 1);
              helper(root.left , 1 , 0);
           }
           else
           {
             helper(root.left , count + 1  , 0);
             helper(root.right , 1 , 1);
           }

           return;
    }
}