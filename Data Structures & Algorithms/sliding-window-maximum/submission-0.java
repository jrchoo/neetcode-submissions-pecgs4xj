class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] results = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        // build the sliding window
        for (int i = 0; i < n; i++) {
            // oldest maximum is out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // if a newer and bigger element is found, repeated remove the smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            // only start assigning once the first window of size k has been created
            if (i >= k - 1) {
                results[index++] = nums[deque.peekFirst()];
            }
        }

        return results;
    }
}
