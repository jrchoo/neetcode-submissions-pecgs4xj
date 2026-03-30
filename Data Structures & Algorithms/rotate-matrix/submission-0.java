class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int k = 0; k < n; k++) {
            int front = 0;
            int back = n - 1;
            while (front < back) {
                int temp = matrix[k][front];
                matrix[k][front] = matrix[k][back];
                matrix[k][back] = temp;
                front++;
                back--;
            }
        }
    }
}
