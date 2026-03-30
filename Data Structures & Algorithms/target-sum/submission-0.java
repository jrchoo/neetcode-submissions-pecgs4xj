class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // let P be the set of numbers assigned a +ve sign
        // let N be the set of numbers assigned a -ve sign
        // (1) Sum(P) - Sum(N) = target (gives a valid solution)
        // (2) Sum(P) + Sum(N) = totalSum (Total sum of array)
        // (1) + (2):
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int subsetTarget = (target + totalSum) / 2;
        // 2 * Sum(P) = target + totalSum (sum of 2 identical integers is always even)
        // Sum(P) = (target + totalSum) / 2 (if odd, solution set does not exist) 
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) {
            return 0; 
        }

        int[] dp = new int[subsetTarget + 1];

        // base case
        dp[0] = 1; // only 1 way to have a target sum of 0

        for (int num : nums) {
            for (int j = subsetTarget; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[subsetTarget];
    }
}
