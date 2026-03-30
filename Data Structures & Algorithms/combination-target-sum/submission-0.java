class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        int start = 0;
        List<Integer> current = new ArrayList<>();
        backtrack(nums, target, start, current, combinations);

        return combinations;
    }

    public void backtrack(int[] nums, int remaining, int start, 
    List<Integer> current, List<List<Integer>> combinations) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, remaining - nums[i], i, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}
