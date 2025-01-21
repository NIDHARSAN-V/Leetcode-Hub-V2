class Solution {
    public boolean exist(char[][] board, String word) {
        if( board.length  *   board[0].length < word.length())
        {
            return false;
        }
        
        for(int i = 0 ; i < board.length ;i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(search(board , word , i , j , 0 , board.length , board[0].length))
                {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean search(char[][] board , String word , int i , int j , int cur , int m , int n)
    {
        if(cur==word.length())
        {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word.charAt(cur) || board[i][j] == '#')  {
            return false;
        }
    

        char x = board[i][j];
        board[i][j] = '#';
        boolean res = search(board , word , i+1 ,j , cur+1 ,  m , n) || search(board , word , i ,j+1 ,cur+1,  m , n) || search(board , word , i-1 ,j ,cur  +1,  m , n) || search(board , word , i ,j-1 ,cur+1,  m , n);
        board[i][j] = x;
        

        return res;
        
    }
}