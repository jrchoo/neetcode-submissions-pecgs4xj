class Solution {
    public int coinChange(int[] coins, int amount) {
        // initialise the dp array
        int[] dp = new int[amount + 1];
        dp[0] = 0; // 0 ways to make up to an amount of 0 with the given coins
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        // loop from 1 to t
        for (int i = 1; i < amount + 1; i++) {
            // at each iteration, loop through the coins
            for (int coin : coins) {
                // coin <= i, it is a valid choice
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // compare to the current minimum
                }
            }
        }
        
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }
}
