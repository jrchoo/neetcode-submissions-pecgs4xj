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
        if (!minimum.isEmpty()) {
            min = Math.min(minimum.peek(), val);
        }
        
        this.minimum.push(min);
    }
    
    public void pop() {
        this.main.pop();
        this.minimum.pop();
    }
    
    public int top() {
        return this.main.peek();
    }
    
    public int getMin() {
        return this.minimum.peek();
    }
}
