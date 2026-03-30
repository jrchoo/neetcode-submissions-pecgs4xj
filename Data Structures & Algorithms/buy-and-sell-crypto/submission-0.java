class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // let dp[i][0] represent the profit on the ith day when no stocks are held
        dp[0][1] = -prices[0]; // let dp[i][1] represent the profit on the ith day when a stock is held

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }
}
