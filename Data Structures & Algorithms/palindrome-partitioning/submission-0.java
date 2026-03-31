class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);
        return results;
    }

    public void backtrack(List<List<String>> results, List<String> current, String s, int start) {
        // base case: reached the end, add current substring
        if (start == s.length()) {
            results.add(new ArrayList<>(current));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrack(results, current, s, i + 1);
                current.remove(current.size() - 1);
            }
           
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
