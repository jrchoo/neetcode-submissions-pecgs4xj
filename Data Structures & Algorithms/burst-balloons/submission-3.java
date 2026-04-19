class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            padded[i + 1] = nums[i]; 
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int left = 0; left <= n - len; left++) {
                int right = left + len + 1;
                for (int k = left + 1; k < right; k++) {
                    int coins = dp[left][k] + padded[left] * padded[k] * padded[right] 
                    + dp[k][right];

                    dp[left][right] = Math.max(dp[left][right], coins); 
                }
            }
        }

        return dp[0][n + 1];
    }
}
