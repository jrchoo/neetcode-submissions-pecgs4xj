class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );
        int[][] closest = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x * x) + (y * y);
            maxHeap.offer(new int[]{i, dist});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            int[] point = maxHeap.poll();
            int x = points[point[0]][0];
            int y = points[point[0]][1];
            closest[i][0] = x;
            closest[i][1] = y;
        }

        return closest;
    }
}
