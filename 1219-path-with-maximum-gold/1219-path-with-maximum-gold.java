class Solution {
    int max =0;
    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]!=0) {
                   dfs(grid, i, j, 0);
                }
            }
        }
        
        return max;
    }
    
    void dfs(int[][] grid , int i, int j, int sum) {
        int row = grid.length;
        int col = grid[0].length;
        if(i >=row || i<0 || j>=col || j < 0 || grid[i][j] == 0) {
            max = Math.max(max, sum);
            return;
        }
        sum = sum + grid[i][j];
        int temp = grid[i][j];
        grid[i][j] = 0;
        dfs(grid, i + 1, j, sum);
        dfs(grid, i , j+ 1, sum);
        dfs(grid, i - 1, j, sum);
        dfs(grid, i , j-1, sum);
        grid[i][j] = temp;
    }
}