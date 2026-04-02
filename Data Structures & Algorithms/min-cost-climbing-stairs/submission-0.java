class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // can either start on 0 or 1 
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            // current floor can be reached from 1 or 2 floors before
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]); 
        }

        return dp[n];
    }
}
