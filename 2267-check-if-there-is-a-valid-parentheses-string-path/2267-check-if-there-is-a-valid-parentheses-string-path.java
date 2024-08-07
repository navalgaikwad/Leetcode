class Solution {
    public boolean hasValidPath(char[][] grid) {
        Boolean[][][] dp = new Boolean[100][100][200];
        return dfs(grid, grid.length - 1, grid[0].length - 1, 0, dp);
    }
    
    Boolean dfs(char[][] grid, int i, int j, int k, Boolean[][][] memo) {
        if( i < 0 || j < 0) {
            return false;
        }
        
         if(grid[i][j] == ')') {
            k++;
        }else {
            k--;
        }
        if(k < 0) {
            return false;
        }
        if(i == 0 && j == 0) {
            return k == 0;
        }
       
        if(memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        Boolean left = dfs(grid, i - 1, j, k, memo);
        Boolean right = dfs(grid, i, j - 1, k, memo);
        memo[i][j][k] = left || right;
        return memo[i][j][k];
    }
}