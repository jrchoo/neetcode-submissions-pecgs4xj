class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    if (backtrack(board, i, j, word, 1)) {
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '.'; // mark cell as visited

        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{-1 , 0}, {1, 0}, {0, -1}, {0, 1}};
        char c = word.charAt(index);

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '.' &&
            board[x][y] == c) {
                if (backtrack(board, x, y, word, index + 1)) {
                    return true;
                }
            }
        }
        board[row][col] = temp;
        return false;
    }
}
