class Solution {
    public int calPoints(String[] operations) {
        // use primitive array as a stack
        int[] stack = new int[operations.length];
        int size = 0;
        int sum = 0;

        for (String op : operations) {
            if (op.equals("+")) {
                stack[size] = stack[size - 1] + stack[size - 2];
                sum += stack[size];
                size++;
            } else if (op.equals("D")) {
                stack[size] = stack[size - 1] * 2;
                sum += stack[size];
                size++;
            } else if (op.equals("C")) {
                // decrementing the pointer overwrites stack[size] in the next iteration
                size--;
                sum -= stack[size];
            } else {
                stack[size] = Integer.parseInt(op);
                sum += stack[size];
                size++;
            }
        }

        return sum;
    }
}