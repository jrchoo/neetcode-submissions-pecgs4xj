class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // final list to store the results
        List<List<Integer>> results = new ArrayList<>();
        // sort the array
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), results);

        return results;
    }

    public void backtrack(int[] candidates, int startIndex, int target,
    List<Integer> current, List<List<Integer>> results) {
        // base cases
        if (target == 0) { // exactly 0, we found a valid combination
            results.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) { // invalid path
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // if current element is same as previous, skip to the next
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // if current number is too large
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], current, results);
            current.remove(current.size() - 1);
        }
    }
}
