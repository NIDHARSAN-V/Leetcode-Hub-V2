class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int battleShips = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){  // Count only new ships
                    dfs(board, i, j);
                    battleShips++;   // Count the ship
                }
            }
        }
        return battleShips;
    }

    private void dfs(char[][] board, int i, int j){
        // Base case: out of bounds or not an 'X'
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X'){
            return;
        }

        board[i][j] = '.';  // Mark as visited by converting to '.'

        // Explore all 4 directions
        dfs(board, i + 1, j);  // Down
        dfs(board, i - 1, j);  // Up
        dfs(board, i, j + 1);  // Right
        dfs(board, i, j - 1);  // Left
    }
}
