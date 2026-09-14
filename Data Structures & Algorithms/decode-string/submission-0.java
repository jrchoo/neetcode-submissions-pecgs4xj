class Solution {
    public String decodeString(String s) {
        // process inner most brackets first
        // use two stacks: one for the count
        Stack<Integer> countStack = new Stack<>();
        // and another for the current string
        Stack<StringBuilder> stringStack = new Stack<>();
        // variable to hold the current number
        int currentNum = 0;
        // stringbuilder object to form the resulting string
        StringBuilder currentString = new StringBuilder();

        // four cases
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // case 1: number
            if (Character.isDigit(c)) {
                currentNum *= 10;
                currentNum += Character.getNumericValue(c);
            } else if (c == '[') { // case 2: open bracket '['
                // save the current string and count and reset
                countStack.push(currentNum);
                currentNum = 0;
                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if (c == ']') { // case 3: close bracket ']'
                // pop from the stacks and process
                // current string will be appended to popped string
                // by 'count' number of times
                int count = countStack.pop();
                StringBuilder savedString = stringStack.pop();
                for (int j = 0; j < count; j++) {
                    savedString.append(currentString);
                }
                // set saved string to the current string
                currentString = savedString;
            } else { // case 4: letter
                // append the the current string
                currentString.append(c);
            }
        }
        // return the resulting string
        return currentString.toString();
    }
}