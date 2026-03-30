class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        // sweep the grid for rotten/fresh fruits
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } 
            }
        }

        if (freshCount == 0) {
            return 0;
        }
        int timeElapsed = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] curr = queue.poll();
                // begin BFS from the initial rotten fruits
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                        freshCount--;
                    }
                }
            }
            
            if (!queue.isEmpty()) {
                timeElapsed++;
            }
        }
        
        return freshCount == 0 ? timeElapsed : -1;
    }
}
