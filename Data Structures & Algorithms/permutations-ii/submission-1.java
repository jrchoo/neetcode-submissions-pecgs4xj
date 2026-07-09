class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort the array to group duplicates next to each other
        Arrays.sort(nums);

        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums,
    boolean[] used) {
        // base case: a permutation has been formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) { // check whether current element has been used
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]); // choose
            backtrack(result, current, nums, used); // explore
            current.remove(current.size() - 1); // remove
            used[i] = false;

        }
    }
}