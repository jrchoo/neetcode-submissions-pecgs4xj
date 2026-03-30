class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] represents the longest increasing subsequence that ends with nums[i]
        int max = 1;
       
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // initalise the array
            
            for (int j = 0; j < i; j++) {
                // for each nums[i], check that nums[j] is strictly smaller
                if (nums[j] < nums[i]) {
                    // either start the subsequence from here, or continue adding to it
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}
