class Solution {
    public int change(int amount, int[] coins) {
        // intialise dp array
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 1; // only 1 way to make up 0 dollars

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < dp.length; j++) {
                // ways to make this amount with coins[i] and without coins[i]
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }
}
