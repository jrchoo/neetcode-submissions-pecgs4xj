class Solution {
    public boolean search(int[] nums, int target) {
        // set a left, mid and right pointer
        int left = 0;
        int right = nums.length - 1;
        // determine which side is sorted by checking the values at left, mid and right respectively
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // check if we found the target
            if (nums[mid] == target) {
                return true;
            } 
            // if all values are equal (due to duplicates), shrink the window (from left and right)
            if (left < right && nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            // compare the two halves
            if (nums[left] <= nums[mid]) { // left half is sorted
                // search on left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }
}