class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // sliding window
        // variable for the shortest length encountered
        int minLength = Integer.MAX_VALUE;
        // sum of the elements in the current window
        int sum = 0;
        int left = 0; 

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // expand to the right until sum >= target
            // slowly shrink from the left until condition is not fulfilled
            while (sum >= target) {
                // update the length
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
            // expand from the right again
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}