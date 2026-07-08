class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        // add elements into helper stack,s2 in reverse order
        while (!s1.isEmpty()) {
            int curr = s1.pop();
            s2.push(curr);
        }

        // push into main stack, s1
        s1.push(x);

        // pour elements back into main stack
        while (!s2.isEmpty()) {
            int curr = s2.pop();
            s1.push(curr);
        }
    }
    
    public int pop() {
        // pop from main stack
        if (!empty()) {
            return s1.pop();
        }
        return 0;
    }
    
    public int peek() {
        if (!empty()) {
            return s1.peek();
        }
        return 0;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */