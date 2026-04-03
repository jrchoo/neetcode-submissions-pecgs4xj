class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track the numbers we've seen
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Single pass through the 81 cells
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                // Convert char '1'-'9' to int 0-8 for array indexing
                int val = board[r][c] - '1';
                
                // Calculate which of the 9 boxes we are currently in
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If we have seen this value in the current row, col, or box, it's invalid
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                // Otherwise, mark it as seen and move on
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}
