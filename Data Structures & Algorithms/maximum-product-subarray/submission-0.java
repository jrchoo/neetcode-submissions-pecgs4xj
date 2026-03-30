class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int[] maxDP = new int[n];
        int[] minDP = new int[n];

        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        // 3 ways to determine new maxDP[i] and min[DP]
        // 1. take the number itself
        // 2. maxDP: prev and current are positive, minDP: prev is positive current negative
        // 3. maxDP: prev and current are negative, minDP: prev is negative current positive

        for (int i = 1; i < n; i++) {
            int current = nums[i];
            int prevMax = maxDP[i - 1];
            int prevMin = minDP[i - 1];
            maxDP[i] = Math.max(current, Math.max(current * prevMax, current * prevMin));
            minDP[i] = Math.min(current, Math.min(current * prevMax, current * prevMin));
            max = Math.max(max, maxDP[i]);
        }

        return max;
    }
}
