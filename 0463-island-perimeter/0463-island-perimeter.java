class Solution {
    int total =0;
    public int islandPerimeter(int[][] grid) {
        for(int i =0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }
    
    void dfs(int[][] grid, int i, int j) {
        if(i>=grid.length || i<0 || j>=grid[0].length||j<0 || grid[i][j]==0 ) {
            total = total + 1;
            return;
        }
        if (grid[i][j] == 2) return;
        grid[i][j] = 2;
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
    }
}