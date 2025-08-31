class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {
        if (r == 9) {  
            return true;
        }
        if (c == 9) {  
            return solve(board, r + 1, 0);
        }
        if (board[r][c] != '.') {  
            return solve(board, r, c + 1);
        }
        
        for (char num = '1'; num <= '9'; num++) {
            if (check(board, r, c, num)) {
                board[r][c] = num;  
                if (solve(board, r, c + 1)) {
                    return true; 
                }
                else
                {
                board[r][c] = '.'; 
                } 
            }
        }
        return false; 
    }

    private boolean check(char[][] board, int r, int c, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == k || board[i][c] == k || 
                board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == k) {
                return false;
            }
        }
        return true;
    }
}
