class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) { // only even sums can be split into 2
            return false;
        }

        int targetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][targetSum + 1];

        return dfs(dp, nums, 0, targetSum);
    }

    public boolean dfs(Boolean[][] dp, int[] nums, int index, int currentSum) {
        // base case
        if (currentSum == 0) { // found a valid combination
            return true;
        }

        if (currentSum < 0 || index == nums.length) { // invalid branch or no valid branches found
            return false;
        }

        if (dp[index][currentSum] != null) {
            return dp[index][currentSum];
        }

        boolean choose = dfs(dp, nums, index + 1, currentSum - nums[index]);
        boolean skip = dfs(dp, nums, index + 1, currentSum);
        dp[index][currentSum] = choose || skip;

        return dp[index][currentSum];
    }
}
