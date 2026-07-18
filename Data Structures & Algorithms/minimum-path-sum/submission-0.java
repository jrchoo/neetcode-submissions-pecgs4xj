class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // base case: starting point
        dp[0][0] = grid[0][0];

        // first row only reached by moving right from (0, 0)
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // first column only reached by moving down from (0, 0)
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        // calculate minimum path sum from (1, 1) to (m - 1, n - 1)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // choose the lesser of the cell directly above and to the left
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}