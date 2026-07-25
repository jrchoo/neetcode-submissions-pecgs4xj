class Solution {
    public int lastStoneWeightII(int[] stones) {
        // subset partition problem, knapsack
        // in order to find the smallest possible weight of the last stone
        // partition the stones into two subsets, s1 & s2 such that
        // s1 + s2 = total sum and minimise the difference s1 - s2
        // (1) s2 = total sum - s1
        // (2) total sum - 2 * s1 -> 0 (make this as small as possible)

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        } 
        // the target weight of a subset we are aiming for
        int target = sum / 2;

        int n = stones.length;
        // dp[i][j] represents being able to make up a sum of j using the first i stones
        boolean[][] dp = new boolean[n + 1][target + 1];

        // base case: a sum of 0 can be achieved by picking 0 stones
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            int currentStone = stones[i - 1];

            for (int j = 1; j <= target; j++) {
                // don't pick the current stone
                dp[i][j] = dp[i - 1][j];

                // pick the current stone
                if (j >= currentStone) {
                    // see if the previous stones can make up the remaining sum
                    dp[i][j] = dp[i][j] || dp[i - 1][j - currentStone];  
                }
            }
        }
        // find the largest possible subset sum s1
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                return sum - (2 * j);
            }
        }

        return 0;
    }
}