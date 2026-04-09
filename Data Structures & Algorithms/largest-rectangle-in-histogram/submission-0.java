class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic stack to store rectangles of increasing heights
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            // rectangles that are shorter than the one at the top of stack becomes
            // the new shortest, calculate the area for the existing rectangles inside
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int index = stack.pop();
                int shortest = heights[index];
                int width = 0;
                if (stack.isEmpty()) { // this is the shortest rectangle
                    width = i;
                } else { // the length from the previous shortest to the current
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, shortest * width);
            }
            // rectangles that are at least the same height of the current rectangle
            // are added onto the stack
            stack.push(i);
        }

        return maxArea;
    }
}
