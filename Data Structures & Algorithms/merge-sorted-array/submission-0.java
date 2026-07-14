class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3 pointers, i, j, k 
        // i to iterate backwards from m - 1
        // j to iterate backwards from n - 1
        // k  to iterate backwards from m + n - 1
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            // compare the two elements, the larger element moves to k
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else { // element at i is smaller
                nums1[k] = nums1[i];
                i--;
            }

            k--;
        }

        // if pointer i has reached the front of the array but there are still
        // elements left in nums2
        while (j >= 0) { // empty the remaining elements of nums2 into nums1
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // if pointer j reaches the front of the array before i, the elements in
        // nums1 is already in the correct position, do nothing
    }
}