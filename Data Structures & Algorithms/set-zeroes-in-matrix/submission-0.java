class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstColumnZero = false;
        // reading
        for (int i = 0; i < matrix.length; i++) {
            // check if first column has a zero
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // set the first element in this row and column to 0 as a marker
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // writing to inner (m-1)x(n-1) matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // writing to row 0
        if (matrix[0][0] == 0) { // if top left is a zero, set row to 0
            for (int j = 0; j < matrix[0].length; j++) {  
                matrix[0][j] = 0;
            }
        }
        
        // check if the first column had a 0
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
