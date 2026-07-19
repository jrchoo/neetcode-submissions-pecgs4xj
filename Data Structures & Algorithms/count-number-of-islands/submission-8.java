class Solution {
    // direction vectors
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        // brute force solution: trace the boundaries of islands (connected 1's) and ensure that the
        // surrounding area are all 0's, then increment a counter, return the counter at the very end
        // requires multiple passes of the grid, overall time complexity would be much higher than O(m*n)

        // optimised approach: running a BFS on a plot of land to discover neighbouring plots of land,
        // the search terminates when there is no more available land or the land has already been visited

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        // do a sweep on the input grid to find plots of land
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { // found a plot of land, begin search for neighbouring land
                    bfs(grid, i, j);
                    islands++; // whether the bfs finds other plots of land or not, this is an island
                    grid[i][j] = '0'; // mutating in-place so the bfs doesn't search here again
                }
            }
        }
        // successfully conducted a search from all possible starting points
        return islands;
    }

    private void bfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        // queue to store the neighbours
        Queue<int[]> queue = new LinkedList<>();
        // add the first cell into the queue
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int[] dir : dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                // within the boundaries of the grid and not stepping on water
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '0') {
                    // able to explore
                    queue.offer(new int[]{x, y});
                    // mark as visited
                    grid[x][y] = '0';
                }
            }
        }
    }
}
