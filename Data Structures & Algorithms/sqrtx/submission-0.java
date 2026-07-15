class Solution {
    public int mySqrt(int x) {
        // base case
        if (x == 0) {
            return 0;
        }
        // the answer lies between 1 and x
        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == x) { // we found a valid square root
                return mid;
            } else if (square < x) { // too small
                low = mid + 1;
                ans = mid;
            } else { // too large
                high = mid - 1;
            }
        }

        return ans;
    }
}