class Solution {
    public int trap(int[] height) {
        // water can only be trapped between two non-zero height columns
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) { // find global maximums
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // the height of the water is determined by the minimum of the two borders
            // and the current column it is on
            if (leftMax < rightMax) {
                totalWater += leftMax - height[left];
                left++;
            } else {
                totalWater += rightMax - height[right];
                right--;
            }
        }
        
        return totalWater;
    }
}
