class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int first = nums[i];
            int left = i + 1;
            int right = n - 1;
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int second = nums[left];
                int third = nums[right];
                int sum = first + second + third;
                if (sum == 0) {
                    triplets.add(Arrays.asList(first, second ,third));
                    while (left < right && nums[left] == second) {
                        left++;
                    }
                    while (left < right && nums[right] == third) {
                        right--;
                    }
                } else if (sum < 0) { // need to add a bigger number
                    left++;
                } else { // need to add a smaller number
                    right--;
                }
            }
        }
        return triplets;
    }
}
