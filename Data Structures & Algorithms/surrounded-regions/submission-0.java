class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        // initial scan to find safe Os
        // scan top and bottom
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        // scan left and right
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            } 
        }

        // final pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') { // turn the surrounded O into an X
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') { // restore the safe Os 
                    board[i][j] = 'O';
                }
            }
         }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != 'O') {
            return;
        }

        // mark as visited (this O is safe)
        board[row][col] = 'S';

        // an O is only safe if it is touching the border of the grid
        // or another O that is touching the border

        // blindly fire dfs in all directions
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            dfs(board, x, y);
        }
    }
}
