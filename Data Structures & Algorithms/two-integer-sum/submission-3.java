class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // naive approach, try to pair each number with another in the array
        // // time complexity: O(n^2), potentially have to try every single pairing
        // // use 2 loops, outer to pick the first number, inner to pick the second
        // for (int i = 0; i < nums.length; i++) {
        //     // cannot select the first number again
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int first = nums[i];
        //         int second = nums[j];
        //         if (first + second == target) { // found  a valid pair
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        // // since there is guaranteed exactly a pair of indices, this should never be reached
        // return new int[]{-1, -1};

        // optimisation with hashmap
        // populate hashmap with the elements and their index in the original array
        // overhead is in instantiating and populating the hashmap
        // one-pass approach, only add element into the map if the complement is not present
        // supports O(1) lookups, overall O(n) time complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        // using a normal for-loop as the loop variable corresponds to the index
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;

            if (map.containsKey(complement)) {
                int index = map.get(complement);

                return new int[]{index, i};
                
            }

            map.put(current, i);
        }

        // this line should never be reached
        return new int[]{-1, -1};
    }
}
