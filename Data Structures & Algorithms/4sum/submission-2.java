class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // list to hold the final results
        List<List<Integer>> quadruplets = new ArrayList<>();
        // sort the array (in ascending order)
        Arrays.sort(nums);

        int n = nums.length;
        // optimisation: if the array does not contain at least 4 elements,
        // there are no valid quadruplets
        if (n < 4) {
            return quadruplets;
        }
        // left and right pointers bounded between j + 1 and n - 1
        // and work inwards, selection does not result in O(n^2)
        // overall time complexity: O(n^3) due to nested loop and selection,
        // dominates time spent on sorting 
        // space complexity: 

        // outer loop, i to select the first number
        for (int i = 0; i < n - 3; i++) {
            // if current number is a duplicate, skip over
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // optimisation: if the sum of the 4 smallest numbers exceed the target,
            // then all other combinations will exceed
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // inner loop, j to select the second number
            for (int j = i + 1; j < n - 2; j++) {
                // if current number is a duplicate, skip over
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // left and right pointer to select the third & fourth number
                int left = j + 1;
                int right = n - 1;
                // select all the valid combinations
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    // adjust pointers according to the value of sum compared to target
                    if (sum < target) { // too small, increment left
                        left++;
                    } else if (sum > target) { // too large, decrement right
                        right--;
                    } else { // found a valid combination 
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // move on to the next pair
                        left++;
                        // if duplicate element is encountered, skip over
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        right--;
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        // return the final results
        return quadruplets;
    }
}