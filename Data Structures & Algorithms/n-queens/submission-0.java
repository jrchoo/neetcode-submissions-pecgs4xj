class Solution {

    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> positiveDiagonal = new HashSet<>();
    private Set<Integer> negativeDiagonal = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        // create n x n grid
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // start from row 0
        backtrack(0, n, board, results);

        return results;
    }

    public void backtrack(int row, int n, char[][] board, List<List<String>> results) {
        if (row == n) { // reached the bottom of the bottom and successfully placed queens
            results.add(convertBoard(board));
            return;
        }
        // try each column
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                // place queen in this cell
                board[row][col] = 'Q';
                // mark the rows, columns and diagonals
                markVisited(row, col);
                // move on to the next row
                backtrack(row + 1, n, board, results);

                // remove queen from this position as it prevents any valid placements
                board[row][col] = '.';
                unmarkVisited(row, col); 
            }
        }
    }

    public List<String> convertBoard(char[][] board) {
        List<String> results = new ArrayList<>();
        int n = board.length;
        

        for (int i = 0; i < n; i++) {
            results.add(new String(board[i]));
        }

        return results;
    }

    public boolean isValid(int row, int col) {
        // a placement is only valid if it is not in the lines of attack from other queens
        int posDiag = row + col;
        int negDiag = row - col;
        return !columns.contains(col) && !positiveDiagonal.contains(posDiag)
        && !negativeDiagonal.contains(negDiag);
    }

    public void markVisited(int row, int col) {
        columns.add(col);
        int posDiag = row + col;
        int negDiag = row - col;
        positiveDiagonal.add(posDiag);
        negativeDiagonal.add(negDiag);
    }

    public void unmarkVisited(int row, int col) {
        columns.remove(col);
        int posDiag = row + col;
        int negDiag = row - col;
        positiveDiagonal.remove(posDiag);
        negativeDiagonal.remove(negDiag);
    }
}
