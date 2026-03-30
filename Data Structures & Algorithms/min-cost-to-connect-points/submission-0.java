class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        // minHeap to store the next closest node
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        queue.offer(new int[]{0, 0});
        int nodesConnected = 0;

        while(nodesConnected != n) {
            int[] curr = queue.poll();
            int index = curr[0];
            int cost = curr[1];
            if (visited[index]) { // already visited
                continue;
            }
            
            visited[index] = true;
            nodesConnected++;
            totalCost += cost;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int manhattanDist = Math.abs(points[index][0] - points[next][0]) 
                    + Math.abs(points[index][1] - points[next][1]);
                    queue.offer(new int[]{next, manhattanDist});
                }
            }
        }
        return totalCost;
    }
}
