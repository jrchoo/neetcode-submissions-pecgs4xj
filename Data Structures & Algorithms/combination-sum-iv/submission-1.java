class Solution {
    public int combinationSum4(int[] nums, int target) {
        // DP approach
        int[] dp = new int[target + 1];

        // base case: no. of ways to make 0 is by not picking anything at all
        dp[0] = 1;

        // outer loop to iterate up to target - 1
        for (int i = 0; i < target; i++) {
            // try to make up to the target with the current number
            for (int num : nums) {
                if (i + num <= target) { // valid combination
                    dp[i + num] += dp[i];
                }
            }
        }

        return dp[target];
    }
}