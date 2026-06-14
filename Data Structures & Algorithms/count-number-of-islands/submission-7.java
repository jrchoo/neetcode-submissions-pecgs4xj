class Solution {
    public int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        // perform initial sweep of the grid to find plots of land
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { // perform BFS from this cell
                    bfs(i, j, grid);
                    islands++;
                    grid[i][j] = '0'; // current cell has been explored
                }
            }
        }

        return islands;
    }

    public void bfs(int row, int col, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // queue to contain the next cells
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                    grid[x][y] = '0'; // mark as visited
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
