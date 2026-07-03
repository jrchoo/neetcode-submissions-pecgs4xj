class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // temp array to store the intermediate sorted results
        int[] temp = new int[n];

        mergeSortHelper(nums, temp, 0, n - 1);

        return nums;
    }

    // helper function to recursively divide the array into halves
    private void mergeSortHelper(int[] nums, int[] temp, int left, int right) {
        // an array of size 1 is already sorted
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        // recursively call the method on both halves
        mergeSortHelper(nums, temp, left, mid);
        mergeSortHelper(nums, temp, mid + 1, right);

        merge(nums, temp, left, mid, right);
    }

    // helper function to merge the halves
    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left; // pointer for left half
        int j = mid + 1; // pointer for right half
        int k = left; // pointer to write to the original array

        while (i <= mid && j <= right) {
            if (temp[i] < temp[j]) { // left is smaller
                nums[k] = temp[i];
                i++;
            } else { // right is smaller
                nums[k] = temp[j];
                j++;
            }

            k++;
        }

        // placing the remaining element from the left half to the end of the array
        while (i <= mid) {
            nums[k] = temp[i];
            i++;
            k++;
        }
    }
}