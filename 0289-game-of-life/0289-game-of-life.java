class Solution {
    int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        { 0, -1},          { 0, 1},
        { 1, -1}, { 1, 0}, { 1, 1}
    };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

       

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 2; 
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = 3; 
                    }
                }
            }
        }

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private int countLiveNeighbors(int[][] b, int i, int j) {
        int n = 0;
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < b.length && newCol >= 0 && newCol < b[0].length) {
                if (b[newRow][newCol] == 1 || b[newRow][newCol] == 2) {
                    n++;
                }
            }
        }
        return n;
    }
}
