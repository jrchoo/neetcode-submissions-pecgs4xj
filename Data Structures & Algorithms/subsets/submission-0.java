class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    public void backtrack(int[] nums, int index, List<Integer> current,
    List<List<Integer>> results) {
        results.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, results);
            current.remove(current.size() - 1);
        }
    }
}
