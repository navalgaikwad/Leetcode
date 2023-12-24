public class Solution {
    public int numEnclaves(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        // Edge case check is unnecessary since we handle this in the loops below
        
        // Run DFS for the first and last column of each row
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        
        // Run DFS for the first and last row of each column
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        
        // Count the remaining ones (1's) in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
       
        return result;
    }
   
    private void dfs(int[][] grid, int i, int j) {
        // Check for out-of-bounds or if the cell is not a 1
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        // Set the cell to 0 to mark it as visited/processed
        grid[i][j] = 0;
        
        // Recursively visit all adjacent cells
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
