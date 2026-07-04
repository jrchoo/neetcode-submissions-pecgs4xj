class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length - 1;

        while (i <= right) {
            if (nums[i] == 0) { // swap this 0 with the element at the left pointer
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            } else if (nums[i] == 2) { // swap this 2 with the element at the right pointer
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else { // 1's are not moved as they belong in between 0's and 2's
                i++;
            }
        }
    }
}