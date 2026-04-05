class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        // creating mapping between digits and their possible letters
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), results, map);
        return results;
    }

    public void backtrack(String digits, int index, StringBuilder current,
    List<String> results, HashMap<Character, String> map) {
        if (index == digits.length()) {
            results.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            char curr = letters.charAt(i);
            current.append(curr);
            backtrack(digits, index + 1, current, results, map);
            current.deleteCharAt(current.length() - 1);
        }

    }
}
