class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();    
    }
    
    public int next(int price) {
        int currentSpan = 1; // by default, the span will always be 1 (the stock on the day itself)

        while (!stack.isEmpty() && stack.peek()[0] <= price) { // current price is more than or equal, increase span
            int[] previous = stack.pop();
            currentSpan += previous[1];
        }
        // current price and accumulated span 
        stack.push(new int[]{price, currentSpan});

        return currentSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */