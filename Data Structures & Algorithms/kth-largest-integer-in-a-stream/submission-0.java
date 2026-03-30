class KthLargest {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int kthLargest;

    public KthLargest(int k, int[] nums) {
        kthLargest = k;
        for (int num : nums) {
            this.add(num);
        }    
    }
    
    public int add(int val) {
        if (minHeap.size() < kthLargest) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        
        return minHeap.peek();
    }
}
