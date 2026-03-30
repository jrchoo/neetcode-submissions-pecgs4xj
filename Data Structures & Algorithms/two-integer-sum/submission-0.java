class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int first = 0;
        

        while(first < n) {
            int second = first + 1;
            while (second < n) {
                if (nums[first] + nums[second] == target) {
                    return new int[]{first, second};
                }
                second++;
            }
            first++;
        }
        return new int[]{};
    }
}
