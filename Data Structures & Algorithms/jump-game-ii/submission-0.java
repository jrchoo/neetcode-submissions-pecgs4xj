class Solution {
    public int jump(int[] nums) {
        int end = nums.length;
        // no. of jumps
        // current end of window of indices we can explore
        // the furthest we can reach
        int jumps = 0;
        int currentEnd = 0;
        int furthest = 0;

        for (int i = 0; i < end - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = furthest;
            }
        }
        return jumps;
    }
}
