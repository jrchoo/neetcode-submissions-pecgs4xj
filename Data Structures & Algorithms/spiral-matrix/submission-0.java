class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();

        // directional pointers
        int top = 0;
        int right = n - 1;
        int down = m - 1;
        int left = 0;

        while (top <= down && left <= right) {
            // go right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]); 
            }
            top++;
            // go down
            for (int j = top; j <= down; j++) {
                spiral.add(matrix[j][right]);
            }
            right--;
            // go left
            if (top <= down) {
                for (int k = right; k >= left; k--) {
                    spiral.add(matrix[down][k]);
                }
                down--;
            }
            // go up
            if (left <= right) {
                for (int l = down; l >= top; l--) {
                    spiral.add(matrix[l][left]);
                }
                left++;
            }
            
        }
        return spiral;
    }
}
