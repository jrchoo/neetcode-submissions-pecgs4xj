class Solution {
    public String simplifyPath(String path) {
        // use a deque to store the elements, easier to empty at the end
        Deque<String> stack = new ArrayDeque<>();

        // tokenise the input filepath, splitting it between slashes
        String[] tokens = path.split("/");
        // process the resulting string array
        for (String token : tokens) {
            // when "" or "." is encountered, do nothing
            if (token.equals("") || token.equals(".")) {
                // skip over to the next token
                continue;
            } else if (token.equals("..")) { // when ".." is encountered, pop from the stack
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else { // otherwise, add the token to the stack
                stack.addLast(token);
            }
        }
        // build the simplified canonical path from the front
        return "/" + String.join("/", stack);
    }
}