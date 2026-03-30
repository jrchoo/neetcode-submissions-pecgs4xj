class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // decreasing monotonic stack
        Deque<Integer> stack = new ArrayDeque<>();
        int[] results = new int[n];
        // iterate from the back of temperatures array
        for (int i = n - 1; i >= 0; i--) {
            // only strictly decreasing temperatures are added onto the stack
            // if the current temperature is greater than the temperature at the top, pop
            // keep popping until the current temperature is no longer greater
            while (!stack.isEmpty()&& temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {    
                results[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return results;
    }
}
