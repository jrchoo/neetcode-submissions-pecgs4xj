class Solution {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] dp;
    private int max = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }

        return max;    
    }

    public int dfs(int[][] matrix, int row, int col) {
        // valid path
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int localMax = 0;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
            && matrix[x][y] > matrix[row][col]) {
                localMax = Math.max(localMax, dfs(matrix, x, y));
            }
            
        }

        dp[row][col] = 1 + localMax;
        return dp[row][col];
    }
}
