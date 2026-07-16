class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // if the sum is not divisible by k, unable to have k equal buckets
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        // target sum for each bucket
        int target = sum / k;
        // sort in descending, try to fit larger values in the bucket first
        Arrays.sort(nums);
        // reverse the array here
        reverse(nums);
        // backtrack
        boolean[] visited = new boolean[nums.length];

        return backtrack(nums, visited, 0, target, 0, k);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int startIndex, 
        int target, int currentSum, int buckets) {
        // when there is 1 bucket left, remaining numbers are guaranteed to fill it
        if (buckets == 1) {
            return true;
        }

        // base case: numbers chosen successfully filled up current bucket
        if (currentSum == target) {
            // restart the search on the next bucket
            return backtrack(nums, visited, 0, target, 0, buckets - 1);
        }

        for (int i = startIndex; i < nums.length; i++) {
            int current = nums[i];
            if (!visited[i] && current + currentSum <= target) { // able to fit
                // choose
                visited[i] = true;
                // explore
                if (backtrack(nums, visited, i + 1, target, currentSum + current, buckets)) {
                    return true;
                }
                // unchoose
                visited[i] = false;
            }
        }

        return false;
    }

    // helper function to reverse an array
    private void reverse(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}