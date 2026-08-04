class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // maintain two states: one for when the previous element was an increase
        // one for when the previous element was a decrease
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        // base case: the minimum length of a subarray will always be 1
        inc[0] = 1;
        dec[0] = 1;
        // global max variable
        int max = 1;

        for (int i = 1; i < n; i++) {
            // consider three scenarios
            if (arr[i] > arr[i - 1]) { // current element is an increase
                inc[i] = dec[i - 1] + 1;
                dec[i] = 1;
            } else if (arr[i] < arr[i - 1]) { // current element is a decrease
                dec[i] = inc[i - 1] + 1;
                inc[i] = 1;
            } else { // neither an increase nor decrease, reset both counts to 1
                inc[i] = 1;
                dec[i] = 1;
            }
            // update the max after every iteration
            max = Math.max(max, Math.max(inc[i], dec[i]));
        }
        // return the maximum
        return max;
    }
}