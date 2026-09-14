class Solution {
    public int subarraySum(int[] nums, int k) {
        // prefix sum + map
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>(); 
        // key: prefix sum (sum of array up to that index)
        // value: number of occurrences of this sum
        // base case: sum before the array starts
        prefixSumMap.put(0, 1);
        // keep track of a running sum variable and a global count
        int count = 0;
        int currentSum = 0;

        // iterate through the array and accumulate
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            // if the current sum - k exists in the map, another subarray is found
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            prefixSumMap.put(currentSum, 
                prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}