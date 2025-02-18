class Solution {
    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    int max = dp(grid, i, j);
                    result = Math.max(result, max);
                }
            }
        }
        return result;
    }
    
    int dp(int[][] grid, int i, int j) {
        if(i < 0 || i>= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int top = dp(grid, i - 1, j);
        int down = dp(grid, i, j-1);
        int up = dp(grid, i+1, j);
        int bottom = dp(grid, i, j + 1);
        grid[i][j] = temp;
        int value = grid[i][j] + Math.max(top, Math.max(down, Math.max(up, bottom)));
        return value;
    }
}