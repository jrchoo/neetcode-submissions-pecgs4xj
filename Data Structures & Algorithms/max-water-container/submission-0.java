class Solution {
    public int maxArea(int[] heights) {
        // initialise left and right pointer
        int left = 0;
        int right = heights.length - 1;
        int max = Integer.MIN_VALUE;
        // start from outer and work inwards
        while (left < right) {
            int leftBar = heights[left];
            int rightBar = heights[right];
            int height = Math.min(leftBar, rightBar);
            // area is the length multiplied by the shorter of the two
            int area = height * (right - left);
            max = Math.max(max, area);
            // as the pointers move, any bar shorter than the previous
            // is guaranteed to produce to smaller area 
            if (leftBar < rightBar) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}
