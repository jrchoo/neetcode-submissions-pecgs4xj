class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int halfLength = (m + n + 1) / 2;

        // perform binary search on the shorter array
        int low = 0;
        int high = m; // length of the shorter array

        while (low <= high) {
            int i = (low + high) / 2; // no. of elements to take from nums1
            int j = halfLength - i; // no. of elements to take from nums2

            // check the 4 boundaries (maxLeftA, minRightA, maxLeftB, minRightB)
            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // the partition is valid if maxLeftA <= minRightB and maxLeftB <= minRightA
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) { // even case
                    int left = Math.max(maxLeftA, maxLeftB);
                    int right = Math.min(minRightA, minRightB);
                    return (left + right) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = i - 1;
            } else { // maxLeftB > minRightA
                low = i + 1;
            }
        }

        return 0.0;         
    }
}
