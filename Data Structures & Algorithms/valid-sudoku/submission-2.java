class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int val = board[row][col] - '1';
                int boxIndex = (row / 3) * 3 + (col / 3);

                if (rows[row][val] || cols[col][val] || boxes[boxIndex][val]) {
                    return false;
                }

                rows[row][val] = true;
                cols[col][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}
