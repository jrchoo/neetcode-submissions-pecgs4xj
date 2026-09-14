class Solution {
    public void rotate(int[] nums, int k) {
        // use array reversal to 'rotate' the array
        int n = nums.length;
        // when k > n, has the same effect as rotating k % n times
        k = k % n;
        // initial reverse of the entire array
        reverse(nums, 0, n - 1);
        // followed by [0, k - 1] and [k, n - 1]
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    // helper method to reverse an array
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}