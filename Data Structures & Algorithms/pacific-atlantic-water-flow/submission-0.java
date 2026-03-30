class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        // maintain 2 visited arrays
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // run reverse DFS from the boundaries
        // loop for vertical edges
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights, heights[i][0]);
            dfs(i, n - 1, atlantic, heights, heights[i][n - 1]);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights, heights[0][j]);
            dfs(m - 1, j, atlantic, heights, heights[m - 1][j]);
        }
        // the intersection of the visited arrays are valid solutions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    results.add(Arrays.asList(i, j));
                }
            }
        }
        return results;
    }

    // water can only travel to equal or higher height
    public void dfs(int row, int col, boolean[][] visited, int[][] heights, int prev) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length
        || visited[row][col] || heights[row][col] < prev) {
            return;
        }

        visited[row][col] = true;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            dfs(x, y, visited, heights, heights[row][col]);
        }
        
    }
}
