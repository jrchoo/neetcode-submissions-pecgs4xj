class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // list to hold the combinations
        List<List<Integer>> combinations = new ArrayList<>();
        // backtrack starting from 1
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        
        return combinations;
    }

    public void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> list) {
        if (current.size() == k) { // valid combination of k numbers found
            list.add(new ArrayList<>(current)); // create copy
            return;
        }

        for (int i = start; i <= n; i++) {
            // choose
            current.add(i);
            // explore
            backtrack(n, k, i + 1, current, list);
            // unchoose
            current.remove(current.size() - 1);
        }
    }
}