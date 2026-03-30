class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int startFrom0 = robHouse(nums, 0, n - 2);
        int startFrom1 = robHouse(nums, 1, n - 1);

        return Math.max(startFrom0, startFrom1);
    }

    public int robHouse(int[] nums, int start, int end) {
        int rob0 = 0; // maximum profit up to two houses ago
        int rob1 = 0; // maximum profit up to one house ago
        for (int i = start; i <= end; i++) {
            // either rob the current house or leave it
            int profit = Math.max(rob0 + nums[i], rob1);
            rob0 = rob1;
            rob1 = profit;  
        }
        return rob1;
    }
}
