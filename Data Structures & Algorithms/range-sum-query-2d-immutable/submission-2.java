class NumMatrix {
    // to support O(1) sum operations, more overhead during the initialisation phase
    // create a 2D prefix sum array using the input grid
    // (sum of all the elements from (0, 0) to that point (row, col))
    private int[][] numMatrix;

    public NumMatrix(int[][] matrix) {
        // base case: empty or null matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        // create a new grid with an extra row and column for padding
        numMatrix = new int[m + 1][n + 1];
        // create the prefix sum array 
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                numMatrix[i][j] = matrix[i - 1][j - 1] + numMatrix[i - 1][j]
                    + numMatrix[i][j - 1] - numMatrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // increment by 1 to account for the padding
        int r1 = row1 + 1;
        int c1 = col1 + 1;
        int r2 = row2 + 1;
        int c2 = col2 + 1;

        // sum of the target region is given by the value at (r2, c2)
        // and subtracting the area above (r1 - 1, c2)
        // and the area to the left (r2, c1 - 1)
        int target = numMatrix[r2][c2];
        int areaAbove = numMatrix[r1 - 1][c2];
        int areaLeft = numMatrix[r2][c1 -1];
        int topLeft = numMatrix[r1 - 1][c1 - 1]; // area to be added back as it is subtracted twice

        return target - areaAbove - areaLeft + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */