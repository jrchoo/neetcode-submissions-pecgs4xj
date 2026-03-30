class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(results, current, 0, 0, n);
        return results;
    }

    public void backtrack(List<String> results, StringBuilder current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            results.add(current.toString());
            return;
        }

        if (openCount < n) { // able to add open bracket
            current.append("(");
            backtrack(results, current, openCount + 1, closeCount, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (closeCount < openCount) { // able to add a close bracket
            current.append(")");
            backtrack(results, current, openCount, closeCount + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
