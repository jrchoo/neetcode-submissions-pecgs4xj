class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // check if first cell is an obstacle
        if (obstacleGrid[0][0] == 1) {
            return 0; // no possible path to the end
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp array to hold number of paths
        int[][] dp = new int [m][n];
        // initial scan for first row & col
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) { // obstacle encountered, every cell after is unreachable
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) { // obstacle encountered, every cell after is unreachable
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}