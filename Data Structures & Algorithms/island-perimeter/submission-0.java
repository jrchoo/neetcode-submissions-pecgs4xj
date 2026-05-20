class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        // iterate through the whole grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // a standalone plot of land has perimeter 4
                    perimeter += 4;

                    // take away 2 edges for every adjacent plot of land
                    if (i > 0 && grid[i - 1][j] == 1) { // check the plot of land directly above 
                        perimeter -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) { // check the plot of land to the left
                        perimeter -= 2;
                    }
                } 
            }
        }

        return perimeter;
    }
}