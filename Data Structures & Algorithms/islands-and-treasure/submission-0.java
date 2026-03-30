class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // scout for treasure
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // add coordinates of the treasure to the queue
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int inf = Integer.MAX_VALUE;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) { // process level by level
                int[] curr = queue.poll();
                // search in all directions
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == inf) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = grid[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }
        
    }
}
