class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        if (n % 2 != 0 || !isOpenBracket(s.charAt(0))) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char bracket = s.charAt(i);
            if (isOpenBracket(bracket)) {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) {
                    char c1 = stack.pop();
                    if (!isCorrectBracket(c1, bracket)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isOpenBracket(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        }
        return false;
    }

    public boolean isCorrectBracket(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        } else if (c1 == '{') {
            return c2 == '}';
        } else {
            return c2 == ']';
        }
    }
}
