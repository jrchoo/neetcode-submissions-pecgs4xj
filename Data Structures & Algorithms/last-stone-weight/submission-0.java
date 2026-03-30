class Solution {
    public int lastStoneWeight(int[] stones) {
        // maintain a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        // at every iteration, get the top 2 and compare
        while (maxHeap.size() >= 2) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            // add the resultant stone back into the heap
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }
        // when 2 stones can no longer be chosen, return the remaining stone
        // or 0 if there are no stones left
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
