class Solution {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        boolean[][] visited = new boolean[m][m];
        //int n = grid[0].length;
        // keep track of a global max
        int tallestSoFar = 0;
        // maintain a min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        minHeap.offer(new int[]{0, 0, grid[0][0]});

        while (!minHeap.isEmpty()) {
            // greedily traverse the next lowest cell
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int height = current[2];
            tallestSoFar = Math.max(tallestSoFar, height);
            // terminate the search when the bottom right has been reached
            if (row == m - 1 && col == m - 1) {
                return tallestSoFar;
            }

            visited[row][col] = true;
            
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < m && visited[x][y] != true) {
                    minHeap.offer(new int[]{x, y, grid[x][y]});
                }
            }
        } 
        
        return tallestSoFar;
    }
}
