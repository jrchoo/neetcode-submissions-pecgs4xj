class Solution {

    private Deque<Integer> stack = new ArrayDeque<>();

    public int evalRPN(String[] tokens) {
        for (String curr : tokens) {
            if (isOperator(curr)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperation(curr, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.peek();
    }

    public boolean isOperator(String token) {
        switch(token) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }

        return false;
    }

    public int applyOperation(String operator, int op1, int op2) {
        int intermediate = 0;
        switch(operator) {

            case "+":
                intermediate = op1 + op2;
                break;
            
            case "-":
                intermediate = op1 - op2;
                break;

            case "*":
                intermediate = op1 * op2;
                break;

            case "/":
                intermediate = op1 / op2;
                break;

        }
        return intermediate;
    }
}
