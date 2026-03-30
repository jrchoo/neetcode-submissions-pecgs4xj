class Solution {
    private int maxArea = 0;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // only perform dfs if unvisited
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        // out of bounds or reached water
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1; // current plot of land

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            area += dfs(grid, x, y);
        }

        return area;
    }
}
