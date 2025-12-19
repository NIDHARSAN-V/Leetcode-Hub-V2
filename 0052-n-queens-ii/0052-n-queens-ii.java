class Solution {
    private int count =0;
    public int totalNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i] , '.');
        }
        // List<List<String>> res = new ArrayList<>();
        backtrack(n,board, 0);
        return count;
    }
    private void backtrack(int n , char[][] board  , int row)
    {
        if(row == n)
        {
            count++;
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(canplace(board,row,col))
            {
                board[row][col] = 'Q';
                backtrack(n , board,row+1);
                board[row][col] = '.'; //backtrack
            }
        }
    }

    private boolean canplace(char[][] board , int row , int col)
    {
        //col
        for(int i=row-1 ; i>=0 ;i--)
        {
            if(board[i][col] == 'Q')
              return false;
        }
        //diag
        
           for(int i=row-1  , j=col-1 ;i>=0 && j>=0 ;i--,j--)
           {
            if(board[i][j]=='Q')
               return false;
           }
        
        //antidiag

          for(int i=row-1 , j=col+1 ; i>=0 && j<board.length ; i--,j++)
          {
            if(board[i][j]=='Q')
            {
                return false;
            }
          }
        return true;
        
            
        
    }

    

    
}
