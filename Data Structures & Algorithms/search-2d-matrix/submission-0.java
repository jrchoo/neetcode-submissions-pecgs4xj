class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            // take the first (minimum) element in the row as a reference
            if (target < matrix[middle][0]) { // target is too small
                // search the rows above
                high = middle - 1;
            // take the last (maximum) element in the row as a reference
            } else if (target > matrix[middle][n - 1]) { // target is too big
                // search the rows below
                low = middle + 1;
            } else { // the target is within this row
                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (target < matrix[middle][mid]) {
                        right = mid - 1;
                    } else if (target > matrix[middle][mid]) {
                        left = mid + 1;
                    } else {
                        // found the target
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }
}
