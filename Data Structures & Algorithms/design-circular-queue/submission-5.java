class MyCircularQueue {
    // FIFO: enqueue from the back and dequeue from the front
    // circular queue maintains a fixed size, O(1) for all operations and no memory reallocation overhead
    private int[] circularQueue;
    private int capacity;
    private int size;
    // keep track of a front and back pointer
    private int front;
    private int back;

    public MyCircularQueue(int k) {
        // initialise the queue with a capacity k
        circularQueue = new int[k];
        capacity = k;
        // starts off with a size of 0
        size = 0;
        front = 0;
        back = -1;    
    }
    
    public boolean enQueue(int value) {
        // check if the queue is already full
        if (this.isFull()) {
            return false;
        }
        // insert value after the back pointer position
        back = (back + 1) % capacity; 
        this.circularQueue[back] = value;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        // remove from the front, advance front pointer to 'free' up the slot 
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        // return the value at the front pointer
        return this.circularQueue[front];
    }
    
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        // return the value at the back pointer
        return this.circularQueue[back];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */