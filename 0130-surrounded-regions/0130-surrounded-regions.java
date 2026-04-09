class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public void solve(char[][] board) {

        int m  = board.length;
        int n =  board[0].length;

        for(int i = 0 ; i < m ;i++)
        {
            helper(board , i , 0 , m, n);
            helper(board , i , n-1 , m , n);
        }


        for(int j = 0 ; j < n ; j++)
        {       
            helper(board , 0 , j , m , n);       
            helper(board , m-1 , j , m , n);  
        }

        

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(board[i][j]=='*')
                {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board ,int i , int j , int m , int n)
    {
        if(i<0 || j < 0 || j >= n || i>= m || board[i][j]!='O')
        {
            return;
        }

        board[i][j] = '*';

        for(int[] d : dirs)
        {
            helper(board , i + d[0] , j+d[1] , m , n);
        }
    }
}