class Solution {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        boolean[][] visited = new boolean[m][m];
        
        // maintain a min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        minHeap.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            // greedily traverse the next lowest cell
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int maxHeightOfPath = current[2];
            // terminate the search when the bottom right has been reached
            if (row == m - 1 && col == m - 1) {
                return maxHeightOfPath;
            }
            
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < m && visited[x][y] != true) {
                    visited[x][y] = true;
                    int tallestSoFar = Math.max(maxHeightOfPath, grid[x][y]);
                    minHeap.offer(new int[]{x, y, tallestSoFar});
                }
            }
        } 
        
        // should never be reached

        return -1;
    }
}
