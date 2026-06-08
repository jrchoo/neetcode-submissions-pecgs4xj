class Solution {
    public int removeElement(int[] nums, int val) {
        // slow and fast pointer 
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) { // fast pointer searches ahead for non-val
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}