class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // acts as a visited array and tracks lowest cost so far
        int[][] minEffort = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;
            }
        }
        // ordered by effort
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // array consisting of effort, row and col
        pq.offer(new int[]{0, 0, 0});
        minEffort[0][0] = 0;

        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            int effort = current[0];
            int row = current[1];
            int col = current[2];

            // if we reached the bottom right, terminate and return the final value
            if (row == m - 1 && col == n - 1) {
                return minEffort[row][col];
            }

            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int heightDiff = Math.abs(heights[row][col] - heights[x][y]);
                    int maxEffort = Math.max(effort, heightDiff);

                    if (maxEffort < minEffort[x][y]) {
                        pq.offer(new int[]{maxEffort, x, y});
                        minEffort[x][y] = maxEffort;
                    }
                }
            }
        }
        // should never be reached
        return 0;
    }
}