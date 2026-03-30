class MinStack {
    private Deque<Integer> main;
    private Deque<Integer> minimum;

    public MinStack() {
        // maintain 2 stacks, one for all elements, one for min elements
        this.main = new ArrayDeque<>();
        this.minimum = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int min = val;
        this.main.push(val);
        // if minimum is empty, or current element <= min
        if (minimum.isEmpty() || val <= this.minimum.peek()) {
            this.minimum.push(val);
        }
    }
    
    public void pop() {
        if (this.main.pop().equals(this.minimum.peek())) {
            this.minimum.pop();
        }
    }
    
    public int top() {
        return this.main.peek();
    }
    
    public int getMin() {
        return this.minimum.peek();
    }
}
