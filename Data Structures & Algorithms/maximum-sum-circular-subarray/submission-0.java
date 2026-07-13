class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        // maintain a max linear subarray and a min linear subarray
        int currentMax = 0;
        int globalMax = nums[0];

        int currentMin = 0;
        int globalMin = nums[0];

        for (int num : nums) {
            // calculate the total sum
            total += num;
            // update max subarray
            currentMax = Math.max(currentMax + num, num);
            globalMax = Math.max(globalMax, currentMax);
            // update min subarray
            currentMin = Math.min(currentMin + num, num);
            globalMin = Math.min(globalMin, currentMin);
        }

        // if nums only consists of negative numbers
        if (globalMax < 0) {
            return globalMax; // the largest of the negative numbers
        }

        // handles the scenario where there is a wraparound, max subarray is then
        // given by total - the min linear subarray
        return Math.max(globalMax, total - globalMin);
    }
}